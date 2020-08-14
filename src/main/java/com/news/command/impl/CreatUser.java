package com.news.command.impl;

import com.news.command.Command;
import com.news.entities.User;
import com.news.exception.ServiceException;
import com.news.service.impl.UserService;

import javax.servlet.http.HttpServletRequest;

public class CreatUser implements Command {
    private UserService userService=new UserService();
    @Override
    public boolean execute(HttpServletRequest request) throws  ServiceException {

        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setEmail("magdy@hotmail.com");
        user.setPassword(password);
        user.setLogin(login);
        userService.create(user);
        return false;
    }
}
