package com.news.command.impl;

import com.news.command.Command;
import com.news.entities.User;
import com.news.exception.ServiceException;
import com.news.service.Service;
import com.news.service.impl.UserService;

import javax.servlet.http.HttpServletRequest;

public class UpdateUser implements Command {
    private final Service <User> service = new UserService();
    @Override
    public boolean execute(HttpServletRequest request) throws ServiceException {
        User user = new User();
        user.setLogin("amamam");
        user.setEmail("hfsydwg@@@");
        user.setName("mamama");
        user.setLastName("jehdjdwkkdsjdd");
        service.update(user);
        return false;
    }
}
