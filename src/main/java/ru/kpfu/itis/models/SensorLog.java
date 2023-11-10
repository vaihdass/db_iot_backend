package ru.kpfu.itis.models;

import java.sql.Timestamp;

public class SensorLog {
    private int sensorLogId;
    private int sensorId;
    private int status;
    private String message;
    private byte[] data;
    private Timestamp time;

    public SensorLog(int sensorLogId) {
        this.sensorLogId = sensorLogId;
    }

    public SensorLog(int sensorId, int status, String message, byte[] data, Timestamp time) {
        this.sensorId = sensorId;
        this.status = status;
        this.message = message;
        this.data = data;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getSensorLogId() {
        return sensorLogId;
    }

    public void setSensorLogId(int sensorLogId) {
        this.sensorLogId = sensorLogId;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
