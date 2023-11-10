package ru.kpfu.itis.dao;

import ru.kpfu.itis.Utils.DatabaseConnectionUtil;
import ru.kpfu.itis.models.Hub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HubDaoImpl {
    private final Connection connection = DatabaseConnectionUtil.getConnection();

    public Hub get(int hubId) {
        try {
            String sql = "SELECT * FROM hubs WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, hubId);

            ResultSet resultset = preparedStatement.executeQuery();
            if (resultset.next()) {
                return new Hub(
                        resultset.getString("Name")
                );
            }
            return null;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void save(Hub hub) {
        String sql = "insert into hubs (name)" +
                " VALUES (?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,hub.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
