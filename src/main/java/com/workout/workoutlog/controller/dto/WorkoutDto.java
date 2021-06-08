package com.workout.workoutlog.controller.dto;

import com.workout.workoutlog.model.Activity;

import java.util.Date;

public class WorkoutDto {

    private long id;
    private Activity activity;
    private Date date;
    private float spentTime;

    public WorkoutDto(long id, Activity activity, Date date, float spentTime) {
        this.id = id;
        this.activity = activity;
        this.date = date;
        this.spentTime = spentTime;
    }

    public long getId() {
        return id;
    }

    public Activity getActivity() {
        return activity;
    }

    public Date getDate() {
        return date;
    }

    public float getSpentTime() {
        return spentTime;
    }

    public void setId(long id) {
        this.id = id;
    }
}
