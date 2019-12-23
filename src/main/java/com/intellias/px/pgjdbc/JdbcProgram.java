package com.intellias.px.pgjdbc;

import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Dictionary;

public class JdbcProgram {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:~/project-x-db");
        Statement statement = connection.createStatement();
        int updatedCount = statement.executeUpdate("create table users (id integer , name varchar(250), password varchar(255))");
        System.out.println("Updated " + updatedCount);
    }
}
