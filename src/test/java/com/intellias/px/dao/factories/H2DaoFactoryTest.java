package com.intellias.px.dao.factories;

import com.intellias.px.dao.UserDao;
import org.junit.Test;

import static org.junit.Assert.*;

public class H2DaoFactoryTest {

    @Test
    public void shouldCreateNotNullUserDao() {
        H2DaoFactory daoFactory = new H2DaoFactory();
        UserDao userDao = daoFactory.createUserDao();
        assertNotNull(userDao);
    }
}