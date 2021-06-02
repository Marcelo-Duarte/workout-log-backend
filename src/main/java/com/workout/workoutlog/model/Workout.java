package com.workout.workoutlog.model;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Workout {
    private String activity;
    private Date date;
    private float spentTime;

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
