package com.br.apiheath.domain.repository;

import com.br.apiheath.domain.entity.Training;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingRepository extends MongoRepository<Training, String> {

    List<Training> findAllByExercisesId(String exerciseId);
}
