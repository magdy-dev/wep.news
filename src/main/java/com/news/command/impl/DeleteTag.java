package com.news.command.impl;

import com.news.command.Command;
import com.news.entities.Tag;
import com.news.exception.ServiceException;
import com.news.service.impl.TagService;

import javax.servlet.http.HttpServletRequest;

public class DeleteTag implements Command {
    private final TagService tagService = new TagService();
    @Override
    public boolean execute(HttpServletRequest request) throws ServiceException {
        Tag tag =new Tag();
        tag.setId(4);
        tagService.delete(tag);

        return false;
    }
}
