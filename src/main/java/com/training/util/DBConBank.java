package com.training.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConBank {
    public static Connection con;
    public static void getConnection() throws SQLException{
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "Aarti@1911");
    }
}
