package com.damiza.my.shop.web.controller;

import com.damiza.my.shop.commons.context.SpringContext;
import com.damiza.my.shop.entity.User;
import com.damiza.my.shop.service.UserService;
import com.damiza.my.shop.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        SpringContext context = new SpringContext();
        UserService userService = (UserService) context.getBean("userService");
        User admin = userService.login(email,password);
        //登录成功
        if(admin != null){
            resp.sendRedirect("/main.jsp");
        }
        //登录失败
        else{
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
    }
}
