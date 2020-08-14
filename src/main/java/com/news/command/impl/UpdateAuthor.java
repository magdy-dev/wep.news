package com.news.command.impl;

import com.news.command.Command;
import com.news.entities.Author;
import com.news.exception.ServiceException;
import com.news.service.Service;
import com.news.service.impl.AuthorService;

import javax.servlet.http.HttpServletRequest;

public class UpdateAuthor implements Command {
    private final Service <Author> service = new AuthorService();
    @Override
    public boolean execute(HttpServletRequest request)throws  ServiceException {
        Author author=new Author();
        author.setName("bcdhjxd");
        author.setLastName("hgdwshde");
        service.delete(author);
        return false;

    }
}
