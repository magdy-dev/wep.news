package com.news.model.impl;

import com.news.entities.Author;
import com.news.exception.DAOException;
import com.news.model.Repository;
import com.news.service.Service;

import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AuthorRepository implements Repository<Author> {
    private static final String INSERT = "INSERT INTO author (name, last_name) VALUES (?,?)";
    private static final String SELECT = "SELECT * FROM author where id=?";
    private static final String UPDATE = "UPDATE author SET name=? ,last_name=? where id =?";
    private static final String DELETE = "DELETE FROM author where id=?";

    @Override
     public void insert(Author entity) throws DAOException {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setString(1,entity.getName());
            statement.setString(2,entity.getLastName());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("author can't insert");
        }

    }

    @Override
    public Author select(int id)throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Author author = new Author();
            if (resultSet.next()){
                author.setId(resultSet.getInt("id"));
                author.setName(resultSet.getString("name"));
                author.setLastName(resultSet.getString("last_name"));
            }
            return author;
        } catch (SQLException e) {
            throw new DAOException(" author can't select");
        }
    }

    @Override
    public void update(Author entity) throws DAOException{

            try {
                PreparedStatement statement = connection.prepareStatement(UPDATE);
                statement.setInt(1,entity.getId());
                statement.setString(2,entity.getName());
                statement.setString(3,entity.getLastName());
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new DAOException("author can't update");
            }

        }

    @Override
    public void delete(Author entity) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw  new DAOException(" author can't delete");
        }

        }

}
