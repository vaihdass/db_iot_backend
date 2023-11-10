package ru.kpfu.itis.models;

public class Hub {
    private int hubId;
    private String name;

    public Hub(String name) {
        this.name = name;
    }

    public int getHubId() {
        return hubId;
    }

    public void setHubId(int hubId) {
        this.hubId = hubId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
