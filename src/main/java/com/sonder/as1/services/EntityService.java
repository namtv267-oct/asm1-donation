package com.sonder.as1.services;

import java.util.List;
import java.util.Optional;

public interface EntityService<T> {
    List<T> getAll();
    void createEntity(T t);
    void updateEntity(T t,Integer id);
    T getById(Integer id);
    void deleteEntity(Integer id);
}
