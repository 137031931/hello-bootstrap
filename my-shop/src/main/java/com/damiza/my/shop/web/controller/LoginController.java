package com.damiza.my.shop.web.controller;

import com.damiza.my.shop.commons.context.SpringContext;
import com.damiza.my.shop.commons.utils.CookieUtils;
import com.damiza.my.shop.entity.User;
import com.damiza.my.shop.service.UserService;
import com.damiza.my.shop.service.impl.UserServiceImpl;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {
    //用常量来表示"userInfo"
    private static final String COOKIE_NAME_USER_INFO="userInfo";
    private UserService userService = SpringContext.getBean(UserServiceImpl.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userInfo = CookieUtils.getCookieValue(req,COOKIE_NAME_USER_INFO);
        if(!StringUtils.isBlank(userInfo)){
            String[] userInfoArray = userInfo.split(":");
            String email = userInfoArray[0];
            String password = userInfoArray[1];
            req.setAttribute("email",email);
            req.setAttribute("password",password);
            req.setAttribute("isChecked",true);
        }

        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        boolean isChecked = req.getParameter("isChecked")==null?false:true;
        //如果用户选择不记住
        if(!isChecked){

            CookieUtils.deleteCookie(req,resp,COOKIE_NAME_USER_INFO);
        }
        User admin = userService.login(email,password);
        //登录成功
        if(admin != null){
            if(isChecked==true){
                //用工具类把user的值储存在cookie中,这里用String的format方法传值可以节省内存
                CookieUtils.setCookie(req,resp,COOKIE_NAME_USER_INFO,String.format("%s:$s",email,password),7*24*60*60);
            }
            resp.sendRedirect("/main.jsp");
        }
        //登录失败
        else{
            req.setAttribute("message","用户名或密码错误");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
    }
}
