package de.home;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo {

    /*
    1. JDBC Driver
    2. Connection
    3. Statement
    4. ResultSet
     */

    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/";
    private static final String DB = "app42_1";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "soly1810";

    public static void loadDriver() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver not found" + DRIVER);
        }
    }

    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL + DB, USERNAME, PASSWORD);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Connection failed" + e.getMessage());
        }
    }

    public static List<User> findAll() {
        String query = "SELECT id, name, email, password FROM backend.t_user";

        try(Connection connection = getConnection()) {
            if(connection == null) {
                throw new SQLException();
            }
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            List<User> result = new ArrayList<>();
            while(resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                User user = new User(id, name, email, password);
                result.add(user);
            }
            return result;

        } catch (SQLException e) {
            throw new RuntimeException("Connection failed" + e.getMessage());
        }
    }

    public static User create(User user) {
        String query = "INSERT INTO backend.t_user(name, email, password) VALUES (?, ?, ?)";

        try(Connection connection = getConnection()) {
            if (connection == null) {
                throw new SQLException();
            }

            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            int rows = statement.executeUpdate();
            if(rows == 0) {
                throw new SQLException("Insert failed");
            }

            ResultSet resultSet = statement.getGeneratedKeys();
            if(!resultSet.next()) {
                throw new SQLException("Id not created");
            } else {
                long id = resultSet.getLong(1);
                user.setId(id);
                return user;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Connection failed" + e.getMessage());
        }
    }
}
