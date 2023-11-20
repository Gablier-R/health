package com.br.apiheath.api.dtoGeneral;

import java.time.LocalDateTime;

public record ExerciseResponseDto(
        String id,
        String name,
        String resume,
        String category,
        String muscleWork,
        String videoOrImage,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
