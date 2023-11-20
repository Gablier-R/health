package com.br.apiheath.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Document(collection = "training")
public class Training {

    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
    private String description;
    private String difficultyTraining;
    private List<Exercise> exercises = new ArrayList<>();
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Training(String name, String description, String difficultyTraining) {
        this.name = name;
        this.description = description;
        this.difficultyTraining = difficultyTraining;
        this.createdAt = LocalDateTime.now();
    }
}
