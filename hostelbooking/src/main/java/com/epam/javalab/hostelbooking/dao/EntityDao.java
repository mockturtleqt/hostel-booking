package com.epam.javalab.hostelbooking.dao;

import com.epam.javalab.hostelbooking.dao.exception.DaoException;

import java.util.List;

public interface EntityDao<Entity> {
    Entity add(Entity entity) throws DaoException;

    Entity findById(int id) throws DaoException;

    List<Entity> findAll() throws DaoException;

    Entity update(Entity entity) throws DaoException;
}
