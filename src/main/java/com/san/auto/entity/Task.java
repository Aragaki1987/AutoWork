package com.san.auto.entity;

import com.san.auto.enums.TypeOfWork;
import com.san.auto.util.DateUtil;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by nguye on 3/25/2017.
 */
public class Task {
    private String keyId;
    private Date startdate;
    private Double time;
    private String description;
    private TypeOfWork typeOfWork;

    public Task() {
    }

    public Task(String keyId, Date startdate, Double time, String description, TypeOfWork typeOfWork) {
        this.keyId = keyId;
        this.startdate = startdate;
        this.time = time;
        this.description = description;
        this.typeOfWork = typeOfWork;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeOfWork getTypeOfWork() {
        return typeOfWork;
    }

    public void setTypeOfWork(TypeOfWork typeOfWork) {
        this.typeOfWork = typeOfWork;
    }

    @Override
    public String toString() {
        return "Task{" +
                "keyId='" + keyId + '\'' +
                ", startdate=" + DateUtil.convertDateString(startdate) +
                ", time=" + time +
                ", description='" + description + '\'' +
                ", typeOfWork=" + typeOfWork +
                '}';
    }
}
