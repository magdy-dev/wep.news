package com.news.command.impl;

import com.news.command.Command;
import com.news.entities.News;
import com.news.exception.ServiceException;
import com.news.service.impl.NewsService;

import javax.servlet.http.HttpServletRequest;

public class DeleteNews implements Command {
    private final NewsService newsService = new NewsService();
    @Override
    public boolean execute(HttpServletRequest request) throws  ServiceException {
        News news = new News();
        news.setId(2);
        newsService.delete(news);
        return false;

    }
}
