package ru.kpfu.itis.dao;

import ru.kpfu.itis.Utils.DatabaseConnectionUtil;
import ru.kpfu.itis.models.UserHubRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserHubRoleDaoImpl {

    private final Connection connection = DatabaseConnectionUtil.getConnection();

    public UserHubRole get(int userId) {
        try {
            String sql = "SELECT * FROM user_hub_role WHERE user_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);

            ResultSet resultset = preparedStatement.executeQuery();
            if (resultset.next()) {
                return new UserHubRole(
                        resultset.getInt("Hub_ID"),
                        resultset.getInt("User_ID"),
                        resultset.getInt("Role_ID")
                );
            }
            return null;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private UserHubRole get(String sql, int id){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultset = preparedStatement.executeQuery();
            if (resultset.next()) {
                return new UserHubRole(
                        resultset.getInt("Hub_ID"),
                        resultset.getInt("User_ID"),
                        resultset.getInt("Role_ID")
                );
            }
            return null;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void save(UserHubRole userHubRole) {
        String sql = "insert into user_hub_role (Hub_ID, User_ID, Role_ID)" +
                " VALUES (?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,userHubRole.getHubId());
            preparedStatement.setInt(2,userHubRole.getUserId());
            preparedStatement.setInt(3,userHubRole.getRoleId());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
