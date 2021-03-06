package com.jiao.web;

import com.jiao.model.Uploadfile;
import com.jiao.service.ResourceService;
import com.jiao.service.UploadfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class InitWebServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    //    将spring ioc容器的引用变量初始化
//    权限初始化，同时拿到域对象，在项目启动时把数据库中所有权限路径都放到域中，防止反复查询
    private static ApplicationContext applicationContext;
    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }
    @Autowired
    private UploadfileService fileService;
    @Override
    public void init(ServletConfig config) throws ServletException {
//        获取域对象
        ServletContext context = config.getServletContext();
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext()); //加上这行
        applicationContext = WebApplicationContextUtils.getWebApplicationContext(context);
        List<Uploadfile> allFiles = fileService.selectAll();
        context.setAttribute("allFiles", allFiles);
        System.out.println("Servlet启动时：" + allFiles);
        try {
            //权限控制初始化
//        扫描包名
            String packageName = "com.jiao.controller";
            String packageNamePath = packageName.replace(".","/");
            String packageNameRealPath = this.getClass().getClassLoader().getResource(packageNamePath).getPath();
            File file = new File(packageNameRealPath);
            String[] classFileNames = file.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    if(name.endsWith(".class")){
                        return true;
                    }
                    return false;
                }
            });

            List<String> paths = new ArrayList<>();

            for(String classFileName : classFileNames) {
                classFileName = classFileName.substring(0, classFileName.indexOf(".class"));
                String classAllpackageName = packageName + "." + classFileName;
                Class clazz = Class.forName(classAllpackageName);
//                没有标记需要权限控制的直接跳过

                if (!clazz.isAnnotationPresent(AuthClass.class)) continue;
                Method[] methods = clazz.getDeclaredMethods();
                for (Method method : methods) {

                    if (!method.isAnnotationPresent(AuthMethod.class)) continue;

                    RequestMapping reqMapping = method.getAnnotation(RequestMapping.class);
                    paths.add(reqMapping.value()[0]);

                }
            }

            ResourceService resourceService = (ResourceService)applicationContext.getBean("resourceService");
            resourceService.initPaths(paths);
            context.setAttribute("allPermissionPaths",paths);//把所有需要权限控制的path存到域中，避免每次都到数据库中查询

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
