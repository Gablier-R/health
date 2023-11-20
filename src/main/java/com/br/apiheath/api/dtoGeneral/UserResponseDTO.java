package com.br.apiheath.api.dtoGeneral;

import java.time.LocalDateTime;

public record UserResponseDTO(
        String id,
        String name,
        String email,
        LocalDateTime createdAt,
        LocalDateTime updateAt,
        String token
) {
}
