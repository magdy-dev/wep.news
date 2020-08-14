package com.news.command.impl;

import com.news.command.Command;
import com.news.entities.Tag;
import com.news.exception.ServiceException;
import com.news.service.Service;
import com.news.service.impl.TagService;

import javax.servlet.http.HttpServletRequest;

public class ReadTag implements Command {
    private Service<Tag> service = new TagService();
    @Override
    public boolean execute(HttpServletRequest request) throws ServiceException {
        Tag tag = service.read(2);
        System.out.println(tag);
        return false;
    }
}
