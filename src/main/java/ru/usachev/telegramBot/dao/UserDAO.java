package ru.usachev.telegramBot.dao;

import ru.usachev.telegramBot.models.User;

import java.sql.*;

public class UserDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/telegramBase";
    private static final String UserName = "root";
    private static final String Password = "Cfif270599!";

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, UserName, Password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public String getUserEmailByName(String userName) {
        String userEmail = null;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT email FROM Users WHERE name = ?");

            preparedStatement.setString(1, userName);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            userEmail = resultSet.getString("email");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userEmail;
    }

    public void save(User user) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO Users (name, age, email) VALUES(?, ?, ?)");

            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setString(3, user.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
