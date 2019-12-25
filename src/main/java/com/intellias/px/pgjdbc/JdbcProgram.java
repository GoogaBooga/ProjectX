package com.intellias.px.pgjdbc;

import com.intellias.px.PXConnectionPool;
import com.intellias.px.entities.Order;
import com.intellias.px.entities.Status;

import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Dictionary;

public class JdbcProgram {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        PXConnectionPool instance = PXConnectionPool.getInstance();
        final Order order = new Order();
        order.setId(1);
        order.setStatus(Status.NEW);

        Connection connection = DriverManager.getConnection("jdbc:h2:~/project-x-db");
        Statement statement = connection.createStatement();
        // Generate database if it is not done
        int updatedCount = statement.executeUpdate("create table if not exists USERS (ID INT not null, NAME VARCHAR(255) not null, PASSWORD VARCHAR(255) not null, constraint USERS_PK primary key (ID))");
        System.out.println("Updated " + updatedCount);
        updatedCount = statement.executeUpdate("create unique index if not exists USERS_ID_UINDEX on USERS (ID)");
        System.out.println("Updated " + updatedCount);

        updatedCount = statement.executeUpdate("create table if not exists PRODUCTS (PROD_ID INT not null, NAME VARCHAR(255) not null, URL VARCHAR(255), constraint PRODUCTS_PK primary key (PROD_ID))");
        System.out.println("Updated " + updatedCount);
        updatedCount = statement.executeUpdate("create unique index if not exists PRODUCTS_PROD_ID_UINDEX on PRODUCTS (PROD_ID)");
        System.out.println("Updated " + updatedCount);

        updatedCount = statement.executeUpdate("create table if not exists SAVEECOBOT (PROD_ID INT, LOC_ID VARCHAR(255) not null, LATITUDE VARCHAR not null, LONGITUDE VARCHAR not null, POLLUTION_TYPE VARCHAR not null, UNIT VARCHAR not null, VALUE VARCHAR not null, DATE DATETIME not null, constraint SAVEECOBOT_PRODUCTS__FK foreign key (PROD_ID) references PRODUCTS (PROD_ID) on update cascade on delete cascade)");
        System.out.println("Updated " + updatedCount);

        updatedCount = statement.executeUpdate("create table if not exists SUBSCRIPTIONS (ID INT, PROD_ID INT, constraint SUBSCRIPTIONS_PRODUCTS__FK foreign key (PROD_ID) references PRODUCTS (PROD_ID) on update cascade on delete cascade, constraint SUBSCRIPTIONS_USERS__FK foreign key (ID) references USERS (ID) on update cascade on delete cascade)");
        System.out.println("Updated " + updatedCount);

    }
}
