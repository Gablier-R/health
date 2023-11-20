package com.br.apiheath.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Document(collection = "user")
public class User {

    @Id
    private String id = UUID.randomUUID().toString();
    @Indexed(unique = true)
    private String email;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String token;

    public User(String email, String name, LocalDateTime now, String token) {
    }
}
