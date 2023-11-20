package com.br.apiheath.domain.repository;

import com.br.apiheath.domain.entity.Exercise;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends MongoRepository<Exercise, String> {
}
