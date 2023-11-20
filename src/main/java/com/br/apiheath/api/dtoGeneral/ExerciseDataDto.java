package com.br.apiheath.api.dtoGeneral;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.mongodb.core.index.Indexed;

public record ExerciseDataDto(
        @NotBlank(message = "name must not be empty")
        @Size(min = 3, message = "name must be greater than 3 letters")
        @Indexed(unique = true)
        String name,

        @NotBlank(message = "name must not be empty")
        @Size(min = 3, message = "name must be greater than 3 letters")
        String resume,

        @NotBlank(message = "name must not be empty")
        @Size(min = 3, message = "name must be greater than 3 letters")
        String category,

        @NotBlank(message = "name must not be empty")
        @Size(min = 3, message = "name must be greater than 3 letters")
        String muscleWork,

        @NotBlank(message = "name must not be empty")
        @Size(min = 3, message = "name must be greater than 3 letters")
        String videoOrImage,

        @NotBlank(message = "name must not be empty")
        @Size(min = 3, message = "name must be greater than 3 letters")
        String description
) {
}
