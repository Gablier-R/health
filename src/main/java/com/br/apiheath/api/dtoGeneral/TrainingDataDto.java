package com.br.apiheath.api.dtoGeneral;

import com.br.apiheath.domain.entity.Exercise;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record TrainingDataDto(

        @NotBlank(message = "name must not be empty")
        @Size(min = 3, message = "name must be greater than 3 letters")
        String name,

        @NotBlank(message = "name must not be empty")
        @Size(min = 3, message = "name must be greater than 3 letters")
        String description,

        @NotBlank(message = "name must not be empty")
        @Size(min = 3, message = "name must be greater than 3 letters")
        String difficultyTraining,

        List<Exercise>exercises
) {
}
