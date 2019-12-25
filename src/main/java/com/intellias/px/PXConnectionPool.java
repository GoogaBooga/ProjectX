package com.intellias.px;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class PXConnectionPool {

    private static final PXConnectionPool instance = new PXConnectionPool();

    private PXConnectionPool() {
    }

    public static  PXConnectionPool getInstance() {
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:~/project-x-db");
    }

}
