package ru.kpfu.itis.dao;

import ru.kpfu.itis.Utils.DatabaseConnectionUtil;

import java.sql.Connection;

public class HubDaoImpl {
    private final Connection connection = DatabaseConnectionUtil.getConnection();

}
