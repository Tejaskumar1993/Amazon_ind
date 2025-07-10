package com.example.amazon_ind.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtil {
    public static String getProductFromDB() {
        String productName = "";
        try {
            String dbUrl = ConfigReader.get("db.url");
            String username = ConfigReader.get("db.username");
            String password = ConfigReader.get("db.password");

            Connection conn = DriverManager.getConnection(dbUrl, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT product_name FROM products LIMIT 1");
            if (rs.next()) {
                productName = rs.getString("product_name");
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productName;
    }
}
