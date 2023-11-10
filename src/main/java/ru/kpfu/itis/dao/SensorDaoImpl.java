package ru.kpfu.itis.dao;

import ru.kpfu.itis.Utils.DatabaseConnectionUtil;
import ru.kpfu.itis.models.Sensor;
import ru.kpfu.itis.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SensorDaoImpl {
    private final Connection connection = DatabaseConnectionUtil.getConnection();

    public Sensor get(int hubId) {
        try {
            String sql = "SELECT * FROM sensors WHERE hub_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, hubId);

            ResultSet resultset = preparedStatement.executeQuery();
            if (resultset.next()) {
                return new Sensor(
                        resultset.getInt("ID"),
                        resultset.getString("Hub_sensor_ID"),
                        resultset.getInt("Hub_ID"),
                        resultset.getString("Name"),
                        resultset.getInt("Type_ID"),
                        resultset.getTimestamp("Date_of_entry")
                );
            }
            return null;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void save(Sensor sensor) {
        String sql = "insert into sensors (hub_sensor_ID, hub_ID ,name, type_ID, date_of_entry)" +
                " VALUES (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,sensor.getHubSensorId());
            preparedStatement.setInt(2,sensor.getHubId());
            preparedStatement.setString(3,sensor.getName());
            preparedStatement.setInt(4,sensor.getTypeId());
            preparedStatement.setTimestamp(5,sensor.getDateOfEntry());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
