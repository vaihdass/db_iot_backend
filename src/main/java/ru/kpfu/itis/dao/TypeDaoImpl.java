package ru.kpfu.itis.dao;

import ru.kpfu.itis.Utils.DatabaseConnectionUtil;
import ru.kpfu.itis.models.Type;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeDaoImpl {

    private final Connection connection = DatabaseConnectionUtil.getConnection();

    public Type get(int typeId) {
        try {
            String sql = "SELECT * FROM types WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, typeId);

            ResultSet resultset = preparedStatement.executeQuery();
            if (resultset.next()) {
                return new Type(
                        resultset.getString("Name"),
                        resultset.getString("Description")
                );
            }
            return null;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void save(Type type) {
        String sql = "insert into types (name, description)" +
                " VALUES (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,type.getName());
            preparedStatement.setString(2,type.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
