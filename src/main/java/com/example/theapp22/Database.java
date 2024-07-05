package com.example.theapp22;

import java.sql.*;

public class Database {
    private Connection connection;

    public Database() {
        String url = "jdbc:postgresql://localhost:5432/TheAppDB";
        String username = "postgres";
        String password = "student";
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Nie udalo sie polaczyc z bazą danych.");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        try {
            System.out.println("Połączono z bazą danych.");
            return this.connection;
        } catch (Exception e) {
            System.out.println("Nie udalo sie polaczyc z baza danych.");
            return null;
        }
    }

    public void closeConnection() {
        try {
            this.connection.close();
            System.out.println("Zamknięto połączenie z bazą danych.");
        } catch (SQLException e) {
            System.out.println("Nie udalo sie zamknac połaczenia z baza danych.");
            e.printStackTrace();
        }
    }



    public void returnColumne(String column){
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT "+column+" FROM dane");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(column));
            }
        } catch (SQLException e) {
            System.out.println("Nie udalo sie pobrac danych z bazy danych.");
            e.printStackTrace();
        }
    }

    public boolean verifyLogin(String inputLogin, String inputPassword) {
        boolean loginSuccessful = false;
        try {
            // Utworzenie zapytania SQL z użyciem PreparedStatement do uniknięcia SQL Injection
            String sql = "SELECT password FROM employees WHERE login = ?";
            PreparedStatement statement = this.connection.prepareStatement(sql);
            ((PreparedStatement) statement).setString(1, inputLogin);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String storedPassword = resultSet.getString("password");
                // Poprawione zapytanie SQL do weryfikacji hasła
                sql = "SELECT password = crypt(?, password) AS match FROM employees WHERE login = ?";
                statement = this.connection.prepareStatement(sql);
                statement.setString(1, inputPassword);
                statement.setString(2, inputLogin);

                ResultSet compareResult = statement.executeQuery();

                if (compareResult.next() && compareResult.getBoolean("match")) {
                    System.out.println("Login successful!");
                    loginSuccessful = true;
                } else {
                    System.out.println("Login failed!");
                }
            } else {
                System.out.println("Login failed!");
            }
        } catch (SQLException e) {
            System.out.println("Error during login verification: " + e.getMessage());
            e.printStackTrace();
        }


        return loginSuccessful;
    }

    public void returnRecord(String column, String value){
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM dane WHERE "+column+" = '"+value+"'");
            while (resultSet.next()) {
                // Przykład wyświetlania wszystkich kolumn dla danego rekordu
                String id = resultSet.getString("id");
                String nazwa = resultSet.getString("nazwa");
                int wartosc = resultSet.getInt("wartosc");
                // Dodaj więcej kolumn zgodnie z Twoją strukturą tabeli
                System.out.println("ID: " + id + ", Nazwa: " + nazwa + ", Wartość: " + wartosc);
            }
        } catch (SQLException e) {
            System.out.println("Nie udalo sie pobrac danych z bazy danych.");
            e.printStackTrace();
        }
    }

    public void returnAll(){
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM dane");
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String nazwa = resultSet.getString("nazwa");
                int wartosc = resultSet.getInt("wartosc");
                System.out.println("ID: " + id + ", Nazwa: " + nazwa + ", Wartość: " + wartosc);
            }
        } catch (SQLException e) {
            System.out.println("Nie udalo sie pobrac danych z bazy danych.");
            e.printStackTrace();
        }
    }

    public void addRecord(String nazwa, int wartosc) {
        try {
            Statement statement = this.connection.createStatement();
            String sql = "INSERT INTO dane (nazwa, wartosc) VALUES ('" + nazwa + "', " + wartosc + ")";
            statement.executeUpdate(sql);
            System.out.println("Dodano nowy rekord do tabeli dane.");
        } catch (SQLException e) {
            System.out.println("Nie udalo sie dodac rekordu do bazy danych.");
            e.printStackTrace();
        }
    }

    public void deleteRecord(int id) {
        try {
            Statement statement = this.connection.createStatement();
            String sql = "DELETE FROM dane WHERE id = " + id;
            statement.executeUpdate(sql);
            System.out.println("Usunięto rekord o id " + id + " z tabeli dane.");
        } catch (SQLException e) {
            System.out.println("Nie udało się usunąć rekordu z bazy danych.");
            e.printStackTrace();
        }
    }

}