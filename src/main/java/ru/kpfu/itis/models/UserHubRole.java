package ru.kpfu.itis.models;

public class UserHubRole {
    private int hubId;
    private int userId;
    private int roleId;

    public UserHubRole(int hubId, int userId, int roleId) {
        this.hubId = hubId;
        this.userId = userId;
        this.roleId = roleId;
    }

    public int getHubId() {
        return hubId;
    }

    public void setHubId(int hubId) {
        this.hubId = hubId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
