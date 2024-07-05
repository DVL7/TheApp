package com.example.theapp22;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database db = new Database();

        //db.addRecord("nazwaa",23);
        db.deleteRecord(9);
        db.returnAll();

        db.closeConnection();
        scanner.close();
    }
}