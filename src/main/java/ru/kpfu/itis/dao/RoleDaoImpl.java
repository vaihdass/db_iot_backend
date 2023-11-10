package ru.kpfu.itis.dao;

import ru.kpfu.itis.Utils.DatabaseConnectionUtil;
import ru.kpfu.itis.models.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDaoImpl {

    private final Connection connection = DatabaseConnectionUtil.getConnection();

    public Role get(int roleId) {
        try {
            String sql = "SELECT * FROM roles WHERE role_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, roleId);

            ResultSet resultset = preparedStatement.executeQuery();
            if (resultset.next()) {
                return new Role(
                        resultset.getString("Name"),
                        resultset.getString("Description"),
                        resultset.getInt("Hub_ID")
                );
            }
            return null;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void save(Role role) {
        String sql = "insert into roles (Name, Description, Hub_ID)" +
                " VALUES (?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,role.getName());
            preparedStatement.setString(2,role.getDescription());
            preparedStatement.setInt(3,role.getHubId());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
