package com.news.command;

import com.news.exception.DAOException;
import com.news.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public interface Command{

    public boolean execute(HttpServletRequest request) throws  ServiceException;
}
