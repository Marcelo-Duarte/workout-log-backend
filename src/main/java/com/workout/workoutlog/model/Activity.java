package com.workout.workoutlog.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_ACTIVITY")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public Activity(String name) {
        this.name = name;
    }

    public Activity() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
