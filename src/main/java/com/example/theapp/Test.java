package com.example.theapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) {
        Database db = new Database();
        Connection connection = db.getConnection();
        db.returnColumne("id");
        db.returnRecord("id", "2");
        db.closeConnection();
    }
}