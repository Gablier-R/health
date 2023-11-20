package com.br.apiheath.api.dtoGeneral;

public record AllResponseDTO<T>(
        T content,
        int pageNo,
        int pageSize,
        int totalPages,
        long totalElements,
        boolean last
) {}


