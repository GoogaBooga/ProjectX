package com.intellias.px.dao;

import com.intellias.px.PXConnectionPool;
import com.intellias.px.entities.User;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class H2UserDao implements UserDao {

    private final PXConnectionPool connectionPool = PXConnectionPool.getInstance();

    @Override
    @SneakyThrows
    public Optional<User> findByLogin(String login) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement("select ID, NAME, PASSWORD from USERS where NAME = ?")) {
            ps.setString(1, login);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                User user = User.builder()
                        .id(resultSet.getInt("ID"))
                        .name(resultSet.getString("NAME"))
                        .password(resultSet.getString("PASSWORD"))
                        .build();
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    @SneakyThrows
    public Optional<User> find(Integer id) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement("select ID, NAME, PASSWORD from USERS where ID = ?")) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                User user = User.builder()
                        .id(resultSet.getInt("ID"))
                        .name(resultSet.getString("NAME"))
                        .password(resultSet.getString("PASSWORD"))
                        .build();
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    @SneakyThrows
    public List<User> findAll() {
        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select ID, NAME, PASSWORD from USERS");
            List <User> list = new ArrayList<>();
            while (resultSet.next()) {
                User user = User.builder()
                        .id(resultSet.getInt("ID"))
                        .name(resultSet.getString("NAME"))
                        .password(resultSet.getString("PASSWORD"))
                        .build();
                list.add(user);
            }
            return list;
        }
    }

    public static void main(String[] args) {
        User user1 = User.builder().name("admin").password("admin").build();
        H2UserDao h2UserDao = new H2UserDao();
//        Boolean result = h2UserDao.delete(user1);
        Optional<User> user2 = h2UserDao.create(user1);
        System.out.println(user2);
    }

    @Override
    @SneakyThrows
    public Optional<User> create(User entity) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement("insert into USERS (NAME, PASSWORD) VALUES (?, ?)", PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getPassword());
            ps.executeUpdate();
            ResultSet id = ps.getGeneratedKeys();
            if (id.next()) {
                entity.setId(id.getInt("ID"));
                return Optional.of(entity);
            }
        }
        return Optional.empty();
    }

    @Override
    @SneakyThrows
    public Optional<User> update(User entity) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement("update USERS set NAME = ?, PASSWORD = ? where ID = ?", PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getPassword());
            ps.setInt(3, entity.getId());
            ps.executeUpdate();
            ResultSet id = ps.getGeneratedKeys();
            if (id.next()) {
                entity.setId(id.getInt("ID"));
                return Optional.of(entity);
            }
        }
        return Optional.empty();
    }

    @Override
    @SneakyThrows
    public boolean delete(User entity) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement("delete from USERS where ID = ?", PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, entity.getId());
            ps.execute();
            return true;
        }
    }
}
