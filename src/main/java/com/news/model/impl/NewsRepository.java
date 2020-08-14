package com.news.model.impl;


import com.news.entities.News;
import com.news.exception.DAOException;
import com.news.model.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class NewsRepository implements Repository<News> {
    private static final String INSERT = "insert into news(title,short_text,full_text, published_in,created_in,author_id)values (?,?,?,?,?,?)";
    private static final String SELECT = "SELECT * FROM news WHERE id=?";
    private static final String UPDATE = "UPDATE news SET full_text=?,short_text=?,title=? where id=?";
    private static final String DELETE = "DELETE FROM news WHERE id=?";


    @Override
    public void insert(News entity) throws DAOException {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setString(3,entity.getTitle());
            statement.setString(2,entity.getShortText());
            statement.setString(1,entity.getFullText());
            statement.executeUpdate();

        }catch (SQLException e) {
            throw new DAOException("news can't insert");
        }

    }

    @Override
    public News select(int id) throws DAOException{
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT)){
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            News news = new News();
            news.setId(resultSet.getInt("id"));
            news.setTitle(resultSet.getString("title"));
            news.setShortText(resultSet.getString("short_text"));
            news.setShortText(resultSet.getString("full_text"));
            news.setPublishedIn(convertToLocalDateViaInstant(resultSet.getDate("published_in")));
            news.setCreatedTn(convertToLocalDateViaInstant(resultSet.getDate("created_in")));
            return news;
        }
        return null;
    } catch (SQLException e) {
        throw new DAOException("news can't select ");
    }
    }

    @Override
    public  void update(News entity) throws DAOException{
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)){
            preparedStatement.setString(1, entity.getFullText());
            preparedStatement.setString(2, entity.getShortText());
            preparedStatement.setString(3,entity.getTitle());
            preparedStatement.setInt(4,entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("news can't update");
        }
    }

    @Override
    public void delete(News entity) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw  new DAOException("news can't delete");
        }

    }
}
