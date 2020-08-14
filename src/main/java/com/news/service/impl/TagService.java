package com.news.service.impl;

import com.news.entities.Tag;
import com.news.exception.DAOException;
import com.news.exception.ServiceException;
import com.news.model.impl.TagRepository;
import com.news.service.Service;

public class TagService implements Service<Tag> {
    private TagRepository repository = new TagRepository();

    @Override
    public void create(Tag entity) throws ServiceException {
        try {
           repository.insert(entity);
        }catch (DAOException e){
           throw new ServiceException("tag cant creat");
        }

    }

    @Override
    public Tag read(int id) throws  ServiceException{
        try {
            Tag tag =repository.select(id);
            return tag;
        } catch (DAOException e) {
            throw new ServiceException("tag  can't read");
        }
    }

    @Override
    public void update(Tag entity) throws  ServiceException{
        try {
            repository.update(entity);
        }catch (DAOException e){
            throw new ServiceException("tag can't update");
        }

    }

    @Override
    public void delete(Tag entity)throws  ServiceException {
        try {
            repository.delete(entity);
        }catch (DAOException e){
            throw new ServiceException("tag can't delete");
        }

    }
}
