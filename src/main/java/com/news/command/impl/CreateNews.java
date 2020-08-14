package com.news.command.impl;

import com.news.command.Command;
import com.news.entities.News;
import com.news.exception.DAOException;
import com.news.exception.ServiceException;
import com.news.service.impl.NewsService;

import javax.servlet.http.HttpServletRequest;

public class CreateNews implements Command {
    private NewsService newsService=new NewsService();
    @Override
    public boolean execute(HttpServletRequest request)throws  ServiceException {
        News news = new News();
        news.setTitle("our company ");
        news.setShortText("out company we love to see u ");
        news.setFullText("welcome our i dont know but welcome any way ");

        newsService.create(news);
        return false;

    }
}
