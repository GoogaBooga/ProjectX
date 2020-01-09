package com.intellias.px.dao.factories;

import com.intellias.px.dao.OrderDao;
import com.intellias.px.dao.UserDao;

public class H2DaoFactory implements DaoFactory{
    @Override
    public UserDao createUserDao() {
        return null;
    }

    @Override
    public OrderDao createOrderDao() {
        return null;
    }
}
