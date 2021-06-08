package com.workout.workoutlog.service;

import com.workout.workoutlog.controller.dto.WorkoutDto;
import com.workout.workoutlog.model.Workout;
import com.workout.workoutlog.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    public WorkoutDto save(WorkoutDto workoutDto) {
        return toDto(workoutRepository.save(toEntity(workoutDto)));
    }

    public List<WorkoutDto> getAll() {
        return workoutRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public WorkoutDto getOne(long id) {
        if(workoutRepository.findById(id).isPresent()) {
            return toDto(workoutRepository.findById(id).get());
        }

        return null;
    }

    public void remove(long id) {
        if(workoutRepository.existsById(id)) {
            workoutRepository.deleteById(id);
        }
    }

    private Workout toEntity(WorkoutDto workoutDto) {
        return new Workout(workoutDto.getActivity(), workoutDto.getDate(), workoutDto.getSpentTime());
    }

    private WorkoutDto toDto(Workout workout) {
        return new WorkoutDto(workout.getId(), workout.getActivity(), workout.getDate(), workout.getSpentTime());
    }
}
