package com.intellias.px.dao.factories;

import com.intellias.px.dao.OrderDao;
import com.intellias.px.dao.ProductDao;
import com.intellias.px.dao.UserDao;

public interface DaoFactory {
    UserDao createUserDao();
    OrderDao createOrderDao();
    ProductDao createProductDao();
}
