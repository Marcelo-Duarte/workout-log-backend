package com.workout.workoutlog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import com.workout.workoutlog.controller.dto.WorkoutDto;
import com.workout.workoutlog.service.WorkoutService;

import java.util.List;

@Controller
@RequestMapping("/workout")
public class WorkoutController {

    @Autowired
    WorkoutService workoutService;

    @GetMapping
    public ResponseEntity<List<WorkoutDto>> getWorkoutList() {
        return ResponseEntity.ok().body(workoutService.getAll());
    }
}
