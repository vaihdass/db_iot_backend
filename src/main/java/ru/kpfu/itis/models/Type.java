package ru.kpfu.itis.models;

public class Type {
    private int typeId;
    private String name;
    private String description;

    public Type(int typeId) {
        this.typeId = typeId;
    }

    public Type(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
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
}
