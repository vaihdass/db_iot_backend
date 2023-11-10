package ru.kpfu.itis.deviceDto;

import ru.kpfu.itis.models.Sensor;
import ru.kpfu.itis.models.Type;

public class SensorWithType {
    private Sensor sensor;
    private Type type;

    public SensorWithType(Sensor sensor, Type type) {
        this.sensor = sensor;
        this.type = type;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}
