package com.workout.workoutlog.service;

import com.workout.workoutlog.controller.dto.ResponseWorkoutDto;
import com.workout.workoutlog.model.Workout;
import com.workout.workoutlog.repository.WorkoutRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseWorkoutDto save(ResponseWorkoutDto responseWorkoutDto) {
        return toDto(workoutRepository.save(toEntity(responseWorkoutDto)));
    }

    public List<ResponseWorkoutDto> getAll() {
        return workoutRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public ResponseWorkoutDto getOne(long id) {
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

    protected Workout toEntity(ResponseWorkoutDto responseWorkoutDto) {
//        return new Workout(activityService.toEntity(workoutDto.getActivityDto()), workoutDto.getDate(), workoutDto.getSpentTime());
        return modelMapper.map(responseWorkoutDto, Workout.class);
    }

    protected ResponseWorkoutDto toDto(Workout workout) {
        //        return new WorkoutDto(workout.getId(), activityService.toDto(workout.getActivity()), workout.getDate(), workout.getSpentTime());
        return modelMapper.map(workout, ResponseWorkoutDto.class);
    }
}
