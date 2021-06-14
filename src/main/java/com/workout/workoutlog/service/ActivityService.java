package com.workout.workoutlog.service;

import com.workout.workoutlog.controller.dto.RequestActivityDto;
import com.workout.workoutlog.controller.dto.ResponseActivityDto;
import com.workout.workoutlog.model.Activity;
import com.workout.workoutlog.repository.ActivityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseActivityDto save(RequestActivityDto requestActivityDto) {
        return toDto(activityRepository.save(toEntity(requestActivityDto)));
    }

    public List<ResponseActivityDto> getAll() {
        return activityRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public ResponseActivityDto getOne(long id) {
        if(activityRepository.findById(id).isPresent()) {
            return toDto(activityRepository.findById(id).get());
        }

        return null;
    }

    public void remove(long id) {
        if(activityRepository.existsById(id)) {
            activityRepository.deleteById(id);
        }
    }

    protected Activity toEntity(RequestActivityDto requestActivityDto) {
        return modelMapper.map(requestActivityDto, Activity.class);
    }

    protected ResponseActivityDto toDto(Activity activity) {
        return modelMapper.map(activity, ResponseActivityDto.class);
    }
}
