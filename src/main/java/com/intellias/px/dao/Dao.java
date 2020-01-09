package com.intellias.px.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<E, I> {

    Optional<E> find(I id);
    List<E> findAll();

    Optional<E> create(E entity);
    Optional<E> update(E entity);
    boolean delete(E entity);
}
