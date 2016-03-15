//package com.madislav.store;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.HandlerExceptionResolver;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Component
//@Controller
//@RequestMapping("/")
//public class GlobalExceptionHandler implements HandlerExceptionResolver {
//
//    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
//    @ExceptionHandler(Exception.class)
//    public ModelAndView resolveException(HttpServletRequest request,
//                                         HttpServletResponse response, Object handler, Exception exception) {
//        logger.error("Request: " + request.getRequestURL() + " raised " + exception);
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", exception);
//        mav.setViewName("error");
//        return mav;
//    }
////    @Override
//
//
//}