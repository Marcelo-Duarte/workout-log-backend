package com.workout.workoutlog.controller;

import com.workout.workoutlog.controller.dto.RequestActivityDto;
import com.workout.workoutlog.controller.dto.ResponseActivityDto;
import com.workout.workoutlog.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @GetMapping
    public ResponseEntity<List<ResponseActivityDto>> getActivityList() {
        return ResponseEntity.ok().body(activityService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseActivityDto> getActivityById(@PathVariable long id) {
        return ResponseEntity.ok().body(activityService.getOne(id));
    }

    @PostMapping
    public ResponseEntity<ResponseActivityDto> saveActivity(@RequestBody RequestActivityDto requestActivityDto, UriComponentsBuilder uriBuilder) {
        ResponseActivityDto activityResponse = activityService.save(requestActivityDto);

        URI uri = uriBuilder.path("/{id}").buildAndExpand(activityResponse).toUri();

        return ResponseEntity.created(uri).body(activityResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteActivity(@PathVariable long id) {
        activityService.remove(id);

        return ResponseEntity.noContent().build();
    }
}
