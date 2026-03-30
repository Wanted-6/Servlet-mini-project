package com.wanted.crud.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String userPwd = req.getParameter("userPwd");

        if (("admin".equals(userId) || "user".equals(userId)) && "1234".equals(userPwd)) {


            HttpSession session = req.getSession();
            session.setAttribute("loginUser", userId);

            resp.sendRedirect(req.getContextPath() + "/");

        } else {
            resp.sendRedirect(req.getContextPath() + "/?error=1");
        }
    }
}