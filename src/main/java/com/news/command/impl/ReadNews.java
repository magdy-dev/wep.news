package com.news.command.impl;

import com.news.command.Command;
import com.news.entities.News;
import com.news.exception.ServiceException;
import com.news.service.Service;
import com.news.service.impl.NewsService;

import javax.servlet.http.HttpServletRequest;

public class ReadNews implements Command {
    private Service<News> service= new NewsService();
    @Override
    public boolean execute(HttpServletRequest request) throws ServiceException {
        News news = service.read(1);
        return false;
    }
}
