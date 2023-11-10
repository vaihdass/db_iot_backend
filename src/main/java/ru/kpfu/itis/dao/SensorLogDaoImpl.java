package ru.kpfu.itis.dao;

import ru.kpfu.itis.Utils.DatabaseConnectionUtil;
import ru.kpfu.itis.models.SensorLog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SensorLogDaoImpl {
    private final Connection connection = DatabaseConnectionUtil.getConnection();

    public SensorLog get(int sensorId) {
        try {
            String sql = "SELECT * FROM sensor_logs WHERE sensor_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, sensorId);

            ResultSet resultset = preparedStatement.executeQuery();
            if (resultset.next()) {
                return new SensorLog(
                        resultset.getInt("Sensor_ID"),
                        resultset.getInt("Status"),
                        resultset.getString("Message"),
                        resultset.getBytes("Data"),
                        resultset.getTimestamp("Time")
                );
            }
            return null;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void save(SensorLog sensorLog) {
        String sql = "insert into sensor_logs (Sensor_ID, Status, Message, Data, Time)" +
                " VALUES (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,sensorLog.getSensorId());
            preparedStatement.setInt(2,sensorLog.getStatus());
            preparedStatement.setString(3,sensorLog.getMessage());
            preparedStatement.setBytes(4,sensorLog.getData());
            preparedStatement.setTimestamp(5,sensorLog.getTime());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
