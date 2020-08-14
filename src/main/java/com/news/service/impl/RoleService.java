package com.news.service.impl;

import com.news.entities.Role;
import com.news.exception.DAOException;
import com.news.exception.ServiceException;
import com.news.model.impl.RoleRepository;
import com.news.service.Service;

public class RoleService implements Service<Role> {
    private RoleRepository roleRepository = new RoleRepository();

    @Override
    public void create(Role entity)throws ServiceException {
        try {
            roleRepository.insert(entity);
        }catch (DAOException e){
            throw new ServiceException("role cant creat");
        }

    }

    @Override
    public Role read(int id)throws  ServiceException {
        try {
           Role role = roleRepository.select(id);
           return role;
        }catch (DAOException e) {
            throw  new ServiceException("not found id");
        }
    }

    @Override
    public void update(Role entity)throws  ServiceException {
        try {
            roleRepository.update(entity);
        }catch (DAOException e){
            throw  new ServiceException("role can't update");
        }


    }

    @Override
    public void delete(Role entity) throws  ServiceException{
        try {
            roleRepository.delete(entity);
        }catch (DAOException e){
            throw  new ServiceException("role can't delete");
        }


    }
}
