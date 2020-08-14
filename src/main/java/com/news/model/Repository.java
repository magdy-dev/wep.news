package com.news.model;

import com.news.exception.DAOException;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public interface Repository<T> {

    Connection connection = ConnectionBuilder.getConnection();

    void insert(T entity) throws DAOException;

    T select(int id) throws DAOException;

    void update(T entity) throws DAOException;

    void delete(T entity) throws DAOException;

    default LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
    }
}
