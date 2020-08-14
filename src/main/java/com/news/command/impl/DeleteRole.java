package com.news.command.impl;

import com.news.command.Command;
import com.news.entities.Role;
import com.news.exception.ServiceException;
import com.news.service.impl.RoleService;

import javax.servlet.http.HttpServletRequest;


public class DeleteRole implements Command {
    private final RoleService roleService = new RoleService();
    @Override
    public boolean execute(HttpServletRequest request) throws ServiceException {
        Role role = new Role();
        role.setId(3);
        roleService.delete(role);
        return false;
    }
}
