package ru.kpfu.itis.dao;

import ru.kpfu.itis.models.Hub;

import java.util.List;

public interface HubDao {
    List<Hub> getByUserId(Integer userId);
}
