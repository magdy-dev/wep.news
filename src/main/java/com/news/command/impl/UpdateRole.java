package com.news.command.impl;

import com.news.command.Command;
import com.news.entities.Role;
import com.news.exception.ServiceException;
import com.news.service.Service;
import com.news.service.impl.RoleService;

import javax.servlet.http.HttpServletRequest;

public class UpdateRole implements Command {
    private final Service <Role> service = new RoleService();
    @Override
    public boolean execute(HttpServletRequest request) throws ServiceException {
        Role role = new Role();
        role.setRole("role");
        service.update(role);
        return false;
    }
}
