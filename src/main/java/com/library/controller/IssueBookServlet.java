package com.library.controller;

import com.library.dao.BookDAO;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/issueBook")

public class IssueBookServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{

        int userId=Integer.parseInt(request.getParameter("userId"));
        int bookId=Integer.parseInt(request.getParameter("bookId"));

        BookDAO dao=new BookDAO();

        if(dao.canIssue(userId)){

            dao.issueBook(userId,bookId);

            response.getWriter().println("Book Issued");

        }
        else{

            response.getWriter().println("User already has a book issued");

        }

    }
}