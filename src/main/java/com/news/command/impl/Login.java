package com.news.command.impl;

import com.news.command.Command;
import com.news.entities.User;
import com.news.exception.ServiceException;
import org.graalvm.compiler.lir.LIRInstruction;

import javax.servlet.http.HttpServletRequest;

public class Login implements Command {
    @Override
    public boolean execute(HttpServletRequest request) throws ServiceException {

        String login = request.getParameter("login");

        return false;
    }
}
