package com.intellias.px.dao;

import com.intellias.px.entities.User;

import java.util.Optional;

public interface UserDao extends Dao<User, Integer>{

    Optional<User> findByLogin(String name);
}
