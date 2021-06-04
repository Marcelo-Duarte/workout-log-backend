package com.workout.workoutlog.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_WORKOUT")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "ACTIVITY_ID")
    private Activity activity;
    private Date date;
    private float spentTime;

    public Workout(Activity activity, Date date, float spentTime) {
        this.activity = activity;
        this.date = date;
        this.spentTime = spentTime;
    }

    public Workout() {
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
}
