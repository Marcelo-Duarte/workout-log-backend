package com.workout.workoutlog.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import com.workout.workoutlog.controller.dto.ResponseWorkoutDto;
import com.workout.workoutlog.service.WorkoutService;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/workout")
public class WorkoutController {

    @Autowired
    WorkoutService workoutService;

    @GetMapping
    public ResponseEntity<List<ResponseWorkoutDto>> getWorkoutList() {
        return ResponseEntity.ok().body(workoutService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseWorkoutDto> getWorkoutById(@PathVariable long id) {
        return ResponseEntity.ok().body(workoutService.getOne(id));
    }

    @PostMapping
    public ResponseEntity<ResponseWorkoutDto> saveWorkout(@RequestBody ResponseWorkoutDto responseWorkoutDto, UriComponentsBuilder uriBuilder) {
        ResponseWorkoutDto workoutResponse = workoutService.save(responseWorkoutDto);

        URI uri = uriBuilder.path("/{id}").buildAndExpand(workoutResponse).toUri();

        return ResponseEntity.created(uri).body(workoutService.save(responseWorkoutDto));
    }
}
