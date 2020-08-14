package com.news.model.impl;

import com.news.entities.Role;
import com.news.entities.Tag;
import com.news.exception.DAOException;
import com.news.model.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TagRepository implements Repository <Tag>{
    private static final String INSERT = "insert into tag(name, news_id)values(?,?)";
    private static final String SELECT = "SELECT * FROM tag WHERE id=?";
    private static final String UPDATE = "UPDATE tag SET name=? where id=?";
    private static final String DELETE = "DELETE  FROM tag WHERE id=?";


    @Override
    public void insert(Tag entity) throws DAOException {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setString(1,entity.getName());
            statement.setInt(2,entity.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            throw new DAOException("tag cant insert");
        }
    }

    @Override
    public Tag select(int id) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT)) {

            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Tag tag = new Tag();
                tag.setName(resultSet.getString("name"));
                return tag;
            }

            return  null;
        } catch (SQLException e) {
            throw new DAOException("tag can't select");
        }

    }

    @Override
    public void update(Tag entity) throws DAOException{
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)){
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2,entity.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException(" tag can't update");
        }

    }

    @Override
    public void delete(Tag entity)throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1,entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("tag can't delete");
        }
    }
    }

