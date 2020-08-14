package com.news.model.impl;

import com.news.entities.Author;
import com.news.entities.News;
import com.news.entities.Tag;
import com.news.entities.User;
import com.news.exception.DAOException;
import com.news.model.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository implements Repository<User> {

    private static final String INSERT ="insert into users (name,last_name,login,password,email) values (?,?,?,?,?);";
    private static final String SELECT = "SELECT * FROM users WHERE id=?";
    private static final String UPDATE = "UPDATE users SET name=?,last_name=?,login=?,password=?,email=? where id=?";
    private static final String DELETE = "DELETE FROM users where id =?";

    @Override
    public void insert(User entity) throws DAOException{
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setString(1,entity.getName());
            statement.setString(2,entity.getLastName());
            statement.setString(3,entity.getLogin());
            statement.setString(4,entity.getPassword());
            statement.setString(5,entity.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
           throw new DAOException("user can't insert");
        }
    }

    @Override
    public User select(int id) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
               User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setLogin(resultSet.getString("login"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
            return null;
        } catch (SQLException e) {
            throw new DAOException("user can't select ");
        }
    }

    @Override
    public void update(User entity)throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)){
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setString(3, entity.getLogin());
            preparedStatement.setString(4, entity.getPassword());
            preparedStatement.setString(5, entity.getEmail());
            preparedStatement.setInt(6,entity.getId());
             preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("user can'tupdat");
        }


    }

    @Override
    public void delete(User entity)throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(" user can't delete");
        }
    }

    }

