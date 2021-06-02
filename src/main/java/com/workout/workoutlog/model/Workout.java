package com.workout.workoutlog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
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
