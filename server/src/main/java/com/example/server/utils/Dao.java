package com.example.server.utils;

import java.util.List;
import java.util.Optional;

public interface Dao<T, ID> {

    Optional<T> get(long id);

    List<T> getAll();

    void save(T t);

    void delete(T t);

    List<T> findAll();
}