package com.br.apiheath.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Document(collection = "exercise")
public class Exercise {

    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
    private String resume;
    private String category;
    private String muscleWork;
    private String videoOrImage;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Exercise(String name, String resume, String category, String muscleWork, String videoOrImage, String description) {
        this.name = name;
        this.resume = resume;
        this.category = category;
        this.muscleWork = muscleWork;
        this.videoOrImage = videoOrImage;
        this.description = description;
        this.createdAt = LocalDateTime.now();
    }

}
