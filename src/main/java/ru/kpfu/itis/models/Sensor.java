package ru.kpfu.itis.models;

import java.sql.Date;
import java.sql.Timestamp;

public class Sensor {
    private int sensorId;
    private String hubSensorId;
    private int hubId;
    private String name;
    private int typeId;
    private Timestamp dateOfEntry;

    public Sensor(int sensorId) {
        this.sensorId = sensorId;
    }

    public Sensor(int sensorId, String hubSensorId, int hubId, String name, int typeId, Timestamp dateOfEntry) {
        this.sensorId = sensorId;
        this.hubSensorId = hubSensorId;
        this.hubId = hubId;
        this.name = name;
        this.typeId = typeId;
        this.dateOfEntry = dateOfEntry;
    }


    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public String getHubSensorId() {
        return hubSensorId;
    }

    public void setHubSensorId(String hubSensorId) {
        this.hubSensorId = hubSensorId;
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

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public Timestamp getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(Timestamp dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }
}
