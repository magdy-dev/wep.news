package com.news.controller;
import com.news.command.Command;
import com.news.command.CommandFactory;
import com.news.entities.User;
import com.news.exception.ServiceException;
import com.news.service.impl.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get");
        doWork(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post");
        doWork(req,resp);
    }

    private void doWork (HttpServletRequest req, HttpServletResponse resp) throws ServletException{
        String commandName = req.getParameter("command");
        Command command = CommandFactory.getCommend(commandName);
        try {
            command.execute(req);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
    }

  
    private void redirect (String url,HttpServletRequest request,HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(request.getContextPath()+url);
        redirect(request,);

    }


    private void forward (String url,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
        requestDispatcher.forward(request,response);

    }
}
