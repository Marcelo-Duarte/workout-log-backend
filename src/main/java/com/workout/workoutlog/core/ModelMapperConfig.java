package com.workout.workoutlog.core;

import com.workout.workoutlog.controller.dto.RequestActivityDto;
import com.workout.workoutlog.controller.dto.ResponseActivityDto;
import com.workout.workoutlog.model.Activity;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap(Activity.class, ResponseActivityDto.class).<Long>addMapping(src -> src.getId(), (dest, value) -> dest.setId(value));

        modelMapper.createTypeMap(RequestActivityDto.class, Activity.class).<String>addMapping(src -> src.getName(), (dest, value) -> dest.setName(value));

        return modelMapper;
    }
}
