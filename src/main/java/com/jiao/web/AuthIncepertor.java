package com.jiao.web;

import com.jiao.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.List;

public class AuthIncepertor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String path;
        /*如果用户输入的url地址在controller里没有相对应的，就给出相应的提示*/
        if (handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();//可以拿到当前url地址对应contrller里面的方法
            RequestMapping annotation = method.getAnnotation(RequestMapping.class);
            path = annotation.value()[0];
        }else {
            throw new RuntimeException("请输入正确的url地址");
        }
        System.out.println(path);
        //1.拿数据库表中的所有权限
        List<String> allPermissionPathes = (List<String>) request.getSession().getServletContext().getAttribute("allPermissionPaths");
        //2.拿当前用户具备的权限
        List<String> loginUserAllPaths = (List<String>)session.getAttribute("loginUserAllPath");
        //3.拿当前登录用户的session
        User loginUser = (User) session.getAttribute("loginUser");

        if(loginUser == null){
            //session是空的就跳转到登录页面
            response.sendRedirect(request.getContextPath() + "/login");
        }else{
            //登陆成功的就判断权限,是项目组长就直接放行
            boolean ismanager = (Boolean) session.getAttribute("ismanager");
            //如果不是项目组长且当前访问路径是需要权限的就进行初步拦截
            if (!ismanager && allPermissionPathes.contains(path)) {
                //拦截到之后进行权限控制，判断当前用户有没有访问当前页面的权限
                //把当前用户拥有的权限和该页面的路径进行比较，如果不包含就给出提示
                if(!loginUserAllPaths.contains(path)){
//                    response.sendRedirect(request.getContextPath() + "/index");
                    throw new RuntimeException("你没有访问该页面的权限");
//                  这里应跳转到首页，即项目浏览页面
                }
            }
        }
//       前面都通过了说明当前用户具备访问改方法的权限，放行
        return super.preHandle(request, response, handler);
    }
}
