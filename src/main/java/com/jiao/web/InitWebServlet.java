package com.jiao.web;

import com.jiao.service.ResourceService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

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
//    权限初始化
    private static ApplicationContext applicationContext;
    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    @Override
    public void init() throws ServletException {
//        获取域对象
        ServletContext context = getServletContext();
        applicationContext = WebApplicationContextUtils.getWebApplicationContext(context);
        System.out.println("初始化了");
        try {
            //        权限控制初始化
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


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
