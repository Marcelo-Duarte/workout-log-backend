package com.workout.workoutlog.service;

import com.workout.workoutlog.controller.dto.ActivityDto;
import com.workout.workoutlog.model.Activity;
import com.workout.workoutlog.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    @Autowired
    ActivityRepository activityRepository;

    public ActivityDto save(ActivityDto activityDto) {
        return toDto(activityRepository.save(toEntity(activityDto)));
    }

    public List<ActivityDto> getAll() {
        return activityRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public ActivityDto getOne(long id) {
        Optional<Activity> activityOptional = activityRepository.findById(id);

        if(activityOptional.isPresent()) {
            return toDto(activityOptional.get());
        }

        return null;
    }

    public void remove(long id) {
        if(activityRepository.existsById(id)) {
            activityRepository.deleteById(id);
        }
    }

    private Activity toEntity(ActivityDto activityDto) {
        return new Activity(activityDto.getName());
    }

    private ActivityDto toDto(Activity activity) {
        return new ActivityDto(activity.getId(), activity.getName());
    }
}
