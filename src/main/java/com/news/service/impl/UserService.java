package com.news.service.impl;

import com.news.entities.User;
import com.news.exception.DAOException;
import com.news.exception.ServiceException;
import com.news.model.impl.UserRepository;
import com.news.service.Service;

public class UserService implements Service<User> {
   private UserRepository userRepository=new UserRepository();

    @Override
    public void create(User entity) throws ServiceException {
        try {
            userRepository.insert(entity);
        } catch (DAOException e) {
            throw new ServiceException("user can't create");
        }

    }

    @Override
    public User read(int id)throws  ServiceException {
        try {
           User user = userRepository.select(id);
           return user;
        } catch (DAOException e) {
            throw new ServiceException("user cant read");
        }
    }

    @Override
    public void update(User entity) throws  ServiceException{
        try {
            userRepository.update(entity);
        }catch (DAOException e){
            throw  new ServiceException("user can't update");
        }

    }

    @Override
    public void delete(User entity) throws  ServiceException{
        try {
            userRepository.delete(entity);
        }catch (DAOException e){
            throw new ServiceException("user can't delete");

        }

    }

}
