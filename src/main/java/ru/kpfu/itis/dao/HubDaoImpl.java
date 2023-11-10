package ru.kpfu.itis.dao;

import ru.kpfu.itis.Utils.DatabaseConnectionUtil;
import ru.kpfu.itis.models.Hub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HubDaoImpl implements HubDao{
    private final Connection connection = DatabaseConnectionUtil.getConnection();

    public Hub get(int hubId) {
        try {
            String sql = "SELECT * FROM hubs WHERE hub_id = ?";
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
        String sql = "insert into hubs (Name)" +
                " VALUES (?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,hub.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Hub> getByUserId(Integer userId) {
        String sql = "select * from account_hub where account_id = ?";

        List<Integer> hubIds = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, userId);
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()) {
                    hubIds.add(resultSet.getInt(2));
                }
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        List<Hub> hubs = new ArrayList<>();

        for (Integer hubId : hubIds) {
            hubs.add(get(hubId));
        }
        return hubs;
    }
}
