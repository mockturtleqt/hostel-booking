package com.epam.javalab.hostelbooking.service;

import com.epam.javalab.hostelbooking.service.exception.ServiceException;

import java.util.List;

public interface EntityService<Entity> {

    Entity add(Entity entity) throws ServiceException;

    List<Entity> findAll() throws ServiceException;

    Entity update(Entity entity) throws ServiceException;
}
