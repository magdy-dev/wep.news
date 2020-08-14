package com.news.service;

import com.news.exception.ServiceException;

public interface Service <T>{
     void create(T entity) throws ServiceException;

     T read(int id) throws ServiceException;

     void update(T entity) throws ServiceException;

     void delete(T entity) throws ServiceException;
}
