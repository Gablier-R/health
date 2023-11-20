package com.br.apiheath.domain.service;

import com.br.apiheath.api.dtoGeneral.*;
import com.br.apiheath.domain.entity.Exercise;
import com.br.apiheath.domain.entity.Training;
import com.br.apiheath.domain.repository.ExerciseRepository;
import com.br.apiheath.domain.repository.TrainingRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TrainingService {

    @Autowired
    TrainingRepository trainingRepository;

    @Autowired
    ExerciseRepository exerciseRepository;

    @Autowired
    ServiceMap serviceMap;

    public TrainingResponseDto createTraining(TrainingDataDto training) {
        var responseTraining = trainingRepository.save(createNewTraining(training));

        return serviceMap.trainingMapToDto(responseTraining);
    }

    public Training createNewTraining(TrainingDataDto dto) {
        return new Training(
                dto.name(),
                dto.description(),
                dto.difficultyTraining()
        );
    }

    public AllResponseDTO trainingQueryAllPageable(int pageNo, int pageSize) {
        Page<Training> trainings = trainingRepository.findAll(PageRequest.of(pageNo, pageSize));

        List<TrainingResponseDto> content = trainings.getContent().stream()
                .map(serviceMap::trainingMapToDto)
                .collect(Collectors.toList());

        return serviceMap.mapToResponseAll(content, trainings);
    }

    public void deleteById(String id){

        verifyTrainingById(id);

        trainingRepository.deleteById(id);
    }

    public TrainingResponseDto updateTraining(String id, TrainingDataDto dataDto){

        var trainingUpdate = verifyTrainingById(id);

        BeanUtils.copyProperties(dataDto, trainingUpdate);
        trainingUpdate.setUpdatedAt(LocalDateTime.now());

        return serviceMap.trainingMapToDto(trainingRepository.save(trainingUpdate));
    }

    public TrainingResponseDto listById(String id){
        return serviceMap.trainingMapToDto(verifyTrainingById(id));
    }

    public TrainingResponseDto addExerciseToTraining(String trainingId, List<String> exerciseIds) {
        Training training = verifyTrainingById(trainingId);

        List<Exercise> existingExercises = training.getExercises();

        List<Exercise> exercisesToAdd = mapIdsToEntities(exerciseIds, this::verifyExerciseById);

        for (Exercise exerciseToAdd : exercisesToAdd) {
            if (!existingExercises.contains(exerciseToAdd)) {
                existingExercises.add(exerciseToAdd);
            }
        }

        training.setUpdatedAt(LocalDateTime.now());

        var trainingResponse = trainingRepository.save(training);

        return serviceMap.trainingMapToDto(trainingResponse);
    }

    public TrainingResponseDto removeExerciseToTraining(String trainingId, String exerciseId) {

        Training training = verifyTrainingById(trainingId);

            if (training.getExercises() != null) {
                training.getExercises().removeIf(exercise -> exercise.getId().equals(exerciseId));
                training.setUpdatedAt(LocalDateTime.now());
                trainingRepository.save(training);
            }

        return serviceMap.trainingMapToDto(training);
    }



    public static <T> List<T> mapIdsToEntities(List<String> ids, Function<String, T> idToEntityFunction) {
        return ids.stream()
                .map(idToEntityFunction)
                .collect(Collectors.toList());
    }

    private Exercise verifyExerciseById(String exerciseId) {
        return exerciseRepository.findById(exerciseId)
                .orElseThrow(() -> new NotFoundException(exerciseId));
    }
    private Training verifyTrainingById(String trainingId) {
        return trainingRepository.findById(trainingId)
                .orElseThrow(() -> new NotFoundException(trainingId));
    }
}
