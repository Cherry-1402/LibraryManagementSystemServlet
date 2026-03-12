package com.library.controller;

import com.library.dao.UserDAO;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/changeRole")

public class ChangeRoleServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{

        int id=Integer.parseInt(request.getParameter("userId"));
        String role=request.getParameter("role");

        UserDAO dao=new UserDAO();

        dao.changeRole(id,role);

        response.getWriter().println("Role Updated");

    }
}