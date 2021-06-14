package com.workout.workoutlog.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestWorkoutDto {

    private ResponseActivityDto responseActivityDto;
    private Date date;
    private float spentTime;
}
