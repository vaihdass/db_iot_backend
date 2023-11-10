package ru.kpfu.itis.models;

public class Role {
    private int roleId;
    private String name;
    private String description;
    private int hubId;

    public Role(int roleId) {
        this.roleId = roleId;
    }

    public Role(String name, String description, int hubId) {
        this.name = name;
        this.description = description;
        this.hubId = hubId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHubId() {
        return hubId;
    }

    public void setHubId(int hubId) {
        this.hubId = hubId;
    }
}
