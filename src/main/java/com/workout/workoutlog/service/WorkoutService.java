package com.workout.workoutlog.service;

import com.workout.workoutlog.controller.dto.WorkoutDto;
import com.workout.workoutlog.model.Workout;
import com.workout.workoutlog.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    public WorkoutDto save(WorkoutDto workoutDto) {
        return toDto(workoutRepository.save(toEntity(workoutDto)));
    }

    private Workout toEntity(WorkoutDto workoutDto) {
        return new Workout(workoutDto.getActivity(), workoutDto.getDate(), workoutDto.getSpentTime());
    }

    private WorkoutDto toDto(Workout workout) {
        return new WorkoutDto(workout.getId(), workout.getActivity(), workout.getDate(), workout.getSpentTime());
    }
}
