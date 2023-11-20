package com.br.apiheath.api.dtoGeneral;

import com.br.apiheath.domain.entity.Exercise;

import java.time.LocalDateTime;
import java.util.List;

public record TrainingResponseDto(

        String id,
        String name,
        String description,
        String difficultyTraining,
        List<Exercise> exercises,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
