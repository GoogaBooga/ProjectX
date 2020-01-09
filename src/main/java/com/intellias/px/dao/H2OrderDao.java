package com.intellias.px.dao;

import com.intellias.px.entities.Order;

import java.util.List;
import java.util.Optional;

public class H2OrderDao implements OrderDao{

    @Override
    public Optional<Order> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Optional<Order> create(Order entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Order> update(Order entity) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Order entity) {
        return false;
    }
}
