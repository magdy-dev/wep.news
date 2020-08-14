package com.news.model.impl;

import com.news.entities.News;
import com.news.entities.Role;
import com.news.exception.DAOException;
import com.news.model.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleRepository implements Repository <Role> {
    private static final String INSERT = " insert into role(id,role)values(?,?) ";
    private static final String SELECT = "SELECT * FROM role WHERE id=?";
    private static final String UPDATE = "UPDATE role SET role=? where id=?";
    private static final String DELETE = "DELETE  FROM role WHERE id=?";


    @Override
    public void insert(Role entity) throws DAOException {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT);
            statement.setInt(1,entity.getId());
            statement.setString(2, entity.getRole());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("role can't insert");
        }
    }

    @Override
    public Role select(int id) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Role role = new Role();
                role.setRole(resultSet.getString("role"));
                return role;
            }

            return  null;
        } catch (SQLException e) {
            throw new DAOException("role can't select");
        }
    }


        @Override
        public  void update (Role entity) throws DAOException {
            try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)){
                preparedStatement.setString(1, entity.getRole());
                preparedStatement.setInt(2,entity.getId());
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                throw new DAOException("role can't update");
            }
        }

        @Override
        public  void delete (Role entity) throws DAOException {
            try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
                preparedStatement.setInt(1,entity.getId());;
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new DAOException("role can't delete");
            }
     }
}

