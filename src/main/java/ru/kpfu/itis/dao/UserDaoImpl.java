package ru.kpfu.itis.dao;

import ru.kpfu.itis.Utils.DatabaseConnectionUtil;
import ru.kpfu.itis.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl {
    private final Connection connection = DatabaseConnectionUtil.getConnection();

    public User get(int userId) {
        try {
            String sql = "SELECT * FROM users WHERE user_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);

            ResultSet resultset = preparedStatement.executeQuery();
            if (resultset.next()) {
                return new User(
                        resultset.getInt("ID"),
                        resultset.getString("Name"),
                        resultset.getString("Email"),
                        resultset.getString("Phone_number"),
                        resultset.getString("Password_hash"),
                        resultset.getString("Password_salt")
                );
            }
            return null;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void save(User user) {
        String sql = "insert into users (Name, Email, Phone_number, Password_hash, Password_salt)" +
                " VALUES (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getPhoneNumber());
            preparedStatement.setString(4,user.getPassword());
            preparedStatement.setString(5,user.getPasswordSalt());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
    public User get(String email) {
        try {
            String sql = "SELECT * FROM users WHERE email = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);

            ResultSet resultset = preparedStatement.executeQuery();
            if (resultset.next()) {
                return new User(
                        resultset.getInt("ID"),
                        resultset.getString("Name"),
                        resultset.getString("Email"),
                        resultset.getString("Phone_number"),
                        resultset.getString("Password_hash"),
                        resultset.getString("Password_salt")
                );
            }
            return null;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
