package com.br.apiheath.domain.service;

import com.br.apiheath.api.dtoGeneral.AllResponseDTO;
import com.br.apiheath.api.dtoGeneral.ExerciseResponseDto;
import com.br.apiheath.api.dtoGeneral.TrainingResponseDto;
import com.br.apiheath.domain.entity.Exercise;
import com.br.apiheath.domain.entity.Training;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMap {

    public <T, U> AllResponseDTO<T> mapToResponseAll(List<T> content, Page<U> paginatedEntity) {
        return (AllResponseDTO<T>) new AllResponseDTO<>(
                content,
                paginatedEntity.getNumber(),
                paginatedEntity.getSize(),
                paginatedEntity.getTotalPages(),
                paginatedEntity.getTotalElements(),
                paginatedEntity.isLast()
        );
    }

    public ExerciseResponseDto exerciseMapToDTO(Exercise exercise) {
        return new ExerciseResponseDto(
                exercise.getId(),
                exercise.getName(),
                exercise.getResume(),
                exercise.getCategory(),
                exercise.getMuscleWork(),
                exercise.getVideoOrImage(),
                exercise.getDescription(),
                exercise.getCreatedAt(),
                exercise.getUpdatedAt()
        );
    }

    public TrainingResponseDto trainingMapToDto(Training training){
        return new TrainingResponseDto(
                training.getId(),
                training.getName(),
                training.getDescription(),
                training.getDifficultyTraining(),
                training.getExercises(),
                training.getCreatedAt(),
                training.getUpdatedAt()
        );
    }
}
