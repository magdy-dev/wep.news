package com.news.service.impl;

import com.news.entities.News;
import com.news.exception.DAOException;
import com.news.exception.ServiceException;
import com.news.model.Repository;
import com.news.model.impl.NewsRepository;
import com.news.service.Service;

public class NewsService implements Service <News>{
    private NewsRepository newsRepository=new NewsRepository();

    @Override
    public void create(News entity)throws ServiceException {
        try {
            newsRepository.insert(entity);
        } catch (DAOException e) {
            throw new ServiceException("news cant creat");
        }

    }

    @Override
    public News read(int id) throws ServiceException{
        try {
            News news = newsRepository.select(id);
        } catch (DAOException e) {
            throw new ServiceException("news can't read");
        }

        return null;
    }

    @Override
    public void update(News entity)throws  ServiceException {

        try {
            newsRepository.update(entity);
        } catch (DAOException e) {
            throw new ServiceException("news can't update");
        }
    }

    @Override
    public void delete(News entity)throws  ServiceException {
        try {
            newsRepository.delete(entity);
        }catch (DAOException e){
            throw  new ServiceException("news can't delete");
        }


    }
}
