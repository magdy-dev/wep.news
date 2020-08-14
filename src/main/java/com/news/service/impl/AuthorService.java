package com.news.service.impl;

import com.news.entities.Author;
import com.news.exception.DAOException;
import com.news.exception.ServiceException;
import com.news.model.impl.AuthorRepository;
import com.news.service.Service;

public class AuthorService implements Service<Author> {

    private AuthorRepository authorRepository = new AuthorRepository();

    @Override
    public void create(Author entity) throws ServiceException {
        try {
            authorRepository.insert(entity);
        } catch (DAOException e) {
            throw new ServiceException("author cant creat");
        }

    }

    @Override
    public Author read(int id) throws ServiceException {
        try {
          Author author=  authorRepository.select(id);
          return author;
        } catch (DAOException e) {
            throw new ServiceException("not found id");
        }
    }


    @Override
    public void update(Author entity) throws ServiceException {
        try {
            authorRepository.update(entity);
        } catch (DAOException e) {
            throw new ServiceException("author can't add");
        }


    }

    @Override
    public void delete(Author entity) throws ServiceException {
        try {
            authorRepository.delete(entity);
        } catch (DAOException e) {
            throw new ServiceException("author can't remove");
        }
    }
}
