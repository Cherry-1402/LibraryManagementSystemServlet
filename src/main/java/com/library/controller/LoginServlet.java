package com.library.controller;

import com.library.dao.UserDAO;
import com.library.model.User;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/login")

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{

        String email=request.getParameter("email");
        String password=request.getParameter("password");

        UserDAO dao=new UserDAO();

        User user=dao.login(email,password);

        if(user!=null){

            HttpSession session=request.getSession();
            session.setAttribute("user",user);

            if(user.getRole().equals("USER"))
                response.sendRedirect("userDashboard.jsp.jsp");

            else if(user.getRole().equals("ADMIN"))
                response.sendRedirect("adminDashboard.jsp.jsp");

            else
                response.sendRedirect("superAdminDashboard.jsp");

        }
        else
            response.getWriter().println("Invalid Login");

    }
}