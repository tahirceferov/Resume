package com.company.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AbstractDao {
public Connection connect() throws Exception{
    String url = "jdbc:mysql://localhost:3306/resume";
    String username = "root";
    String password = "12345" ;
    Connection c = DriverManager.getConnection(url,username,password);
    return c;

}
}
