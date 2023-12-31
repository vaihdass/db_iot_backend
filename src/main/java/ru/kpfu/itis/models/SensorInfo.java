package ru.kpfu.itis.models;

import java.sql.Date;
import java.sql.Timestamp;

public class SensorInfo {
    private String id;
    private String name;
    private String result;
    private String typeName;
    private String typeDescription;
    private String dateOfEntry;
    private String dateOfEdit;

    public SensorInfo(String id, String name, String result, String typeName, String typeDescription, String dateOfEntry, String dateOfEdit) {
        this.id = id;
        this.name = name;
        this.result = result;
        this.typeName = typeName;
        this.typeDescription = typeDescription;
        this.dateOfEntry = dateOfEntry;
        this.dateOfEdit = dateOfEdit;
    }

    public String getDateOfEdit() {
        return dateOfEdit;
    }

    public void setDateOfEdit(String dateOfEdit) {
        this.dateOfEdit = dateOfEdit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    public String getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(String dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }

    @Override
    public String toString() {
        return "SensorInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", result='" + result + '\'' +
                ", typeName='" + typeName + '\'' +
                ", typeDescription='" + typeDescription + '\'' +
                ", dateOfEntry='" + dateOfEntry + '\'' +
                ", dateOfEdit='" + dateOfEdit + '\'' +
                '}';
    }
}
