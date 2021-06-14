package com.workout.workoutlog.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ResponseWorkoutDto {

    private long id;
    private ResponseActivityDto responseActivityDto;
    private Date date;
    private float spentTime;
}
