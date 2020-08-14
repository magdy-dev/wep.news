package com.news.command.impl;

import com.news.command.Command;
import com.news.entities.Author;
import com.news.exception.ServiceException;
import com.news.service.impl.AuthorService;

import javax.servlet.http.HttpServletRequest;


public class DeleteAuthor implements Command {
    private final AuthorService authorService = new AuthorService();
    @Override
    public boolean execute(HttpServletRequest request) throws ServiceException {
        Author author = new Author();
        author.setId(1);
     authorService.delete(author);
        return false;

    }
}
