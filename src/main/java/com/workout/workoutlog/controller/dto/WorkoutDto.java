package com.workout.workoutlog.controller.dto;

import java.util.Date;

public class WorkoutDto {

    private long id;
    private String activity;
    private Date date;
    private float spentTime;

    public WorkoutDto(long id, String activity, Date date, float spentTime) {
        this.id = id;
        this.activity = activity;
        this.date = date;
        this.spentTime = spentTime;
    }

    public long getId() {
        return id;
    }

    public String getActivity() {
        return activity;
    }

    public Date getDate() {
        return date;
    }

    public float getSpentTime() {
        return spentTime;
    }
}
