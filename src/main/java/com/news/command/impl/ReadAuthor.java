package com.news.command.impl;

import com.news.command.Command;
import com.news.entities.Author;
import com.news.exception.ServiceException;
import com.news.service.Service;
import com.news.service.impl.AuthorService;

import javax.servlet.http.HttpServletRequest;

public class ReadAuthor implements Command {
    private final Service<Author> service = new AuthorService();

    @Override
    public boolean execute(HttpServletRequest request) throws ServiceException {
        Author author =service.read(2);
        System.out.println(author);
        return false;
    }
}
