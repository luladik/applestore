//package com.madislav.store.interceptor;
////Created by Luladik on 2/7/2016.
//
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
//public class SecurityInterceptor extends HandlerInterceptorAdapter {
//
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
//                             Object handler) throws Exception {
//        System.out.println("Request Completed");
//        String loginUrl = request.getContextPath() + "/login";
//        if (request.getSession().getAttribute("loggedInUser") == null) {
//            response.sendRedirect(loginUrl);
//            return false;
//        }
//        return true;
//    }
//
//}
