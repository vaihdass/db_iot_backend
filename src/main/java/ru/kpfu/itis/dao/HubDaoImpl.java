package ru.kpfu.itis.dao;

import ru.kpfu.itis.Utils.DatabaseConnectionUtil;
import ru.kpfu.itis.deviceDto.SensorWithType;
import ru.kpfu.itis.models.Hub;
import ru.kpfu.itis.models.Sensor;
import ru.kpfu.itis.models.Type;

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
    public List<SensorWithType> getSensorsByHubId(int hubId) {
        List<SensorWithType> sensorsWithTypes = new ArrayList<>();

        String sql = "SELECT s.id, s.hub_sensor_id, s.hub_id, s.name , s.type_id, s.date_of_entry, " +
                "t.id, t.name AS typeName, t.description " +
                "FROM SENSORS s " +
                "JOIN TYPES t ON s.type_id = t.id " +
                "WHERE s.hub_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, hubId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Type type = new Type(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("description")
                    );
                    Sensor sensor = new Sensor(
                            resultSet.getInt("id"),
                            resultSet.getString("hub_sensor_id"),
                            resultSet.getInt("hub_id"),
                            resultSet.getString("name"),
                            resultSet.getInt("type_id"),
                            resultSet.getTimestamp("date_of_entry")
                    );
                    SensorWithType sensorWithType = new SensorWithType(sensor, type);
                    sensorsWithTypes.add(sensorWithType);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sensorsWithTypes;
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
