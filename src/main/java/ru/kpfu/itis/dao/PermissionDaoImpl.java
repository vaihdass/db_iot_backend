package ru.kpfu.itis.dao;

import ru.kpfu.itis.Utils.DatabaseConnectionUtil;
import ru.kpfu.itis.models.Permission;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PermissionDaoImpl {

    private final Connection connection = DatabaseConnectionUtil.getConnection();

    public Permission get(int permissionId) {
        try {
            String sql = "SELECT * FROM permissions WHERE permission_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, permissionId);

            ResultSet resultset = preparedStatement.executeQuery();
            if (resultset.next()) {
                return new Permission(
                        resultset.getInt("Type_ID"),
                        resultset.getString("Name"),
                        resultset.getString("Description")
                );
            }
            return null;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void save(Permission permission) {
        String sql = "insert into permissions (Type_ID, Name, Description)" +
                " VALUES (?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,permission.getTypeId());
            preparedStatement.setString(2,permission.getName());
            preparedStatement.setString(3,permission.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
