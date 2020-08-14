package com.news.command.impl;

import com.news.command.Command;
import com.news.entities.News;
import com.news.exception.ServiceException;
import com.news.service.Service;
import com.news.service.impl.NewsService;

import javax.servlet.http.HttpServletRequest;

public class UpdateNews implements Command {
    private final Service <News> service = new NewsService();
    @Override
    public boolean execute(HttpServletRequest request) throws  ServiceException {
        News news = new News();
        news.setId(3);
        news.setTitle("titlegrettr");
        news.setShortText("srttrthortText");
        news.setFullText("fulrettetretrettlText");
        service.update(news);
        return false;

    }
}
