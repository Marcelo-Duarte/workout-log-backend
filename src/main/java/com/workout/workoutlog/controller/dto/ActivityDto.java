package com.workout.workoutlog.controller.dto;

public class ActivityDto {

    private long id;
    private String name;

    public ActivityDto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
