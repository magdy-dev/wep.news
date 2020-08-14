package com.news.command.impl;

import com.news.command.Command;
import com.news.entities.User;
import com.news.exception.ServiceException;
import com.news.service.impl.UserService;

import javax.servlet.http.HttpServletRequest;

public class DeleteUser implements Command {
    private final UserService userService = new UserService();
    @Override
    public boolean execute(HttpServletRequest request) throws ServiceException {
        User user = new User();
        user.setId(1);
        userService.delete(user);
        return false;
    }
}
