package com.news.command.impl;

import com.news.command.Command;
import com.news.entities.Tag;
import com.news.exception.ServiceException;
import com.news.service.Service;
import com.news.service.impl.TagService;

import javax.servlet.http.HttpServletRequest;

public class UpdateTag implements Command {
    private final Service <Tag> service= new TagService();
    @Override
    public boolean execute(HttpServletRequest request) throws ServiceException {
        Tag tag = new Tag();
        tag.setName("tag");
        service.update(tag);
        return false;
    }
}
