package com.br.apiheath.domain.service;

import com.br.apiheath.api.dtoGeneral.AllResponseDTO;
import com.br.apiheath.api.dtoGeneral.ExerciseDataDto;
import com.br.apiheath.api.dtoGeneral.ExerciseResponseDto;
import com.br.apiheath.domain.entity.Exercise;
import com.br.apiheath.domain.entity.Training;
import com.br.apiheath.domain.repository.ExerciseRepository;
import com.br.apiheath.domain.repository.TrainingRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExerciseService {

    @Autowired
    ExerciseRepository exerciseRepository;

    @Autowired
    TrainingRepository trainingRepository;

    @Autowired
    ServiceMap serviceMap;


    public ExerciseResponseDto createExercise(ExerciseDataDto exercise){

        var responseExercise =  exerciseRepository.save(createNewExercise(exercise));

        return serviceMap.exerciseMapToDTO(responseExercise);
    }

    public ExerciseResponseDto listById(String id){

        return serviceMap.exerciseMapToDTO(verifyExerciseById(id));
    }

    public void deleteById(String id){

        verifyExerciseById(id);

        exerciseRepository.deleteById(id);
    }

    public ExerciseResponseDto updateExercise(String id, ExerciseDataDto dataDto) {
        Exercise exerciseToUpdate = verifyExerciseById(id);

        BeanUtils.copyProperties(dataDto, exerciseToUpdate);
        exerciseToUpdate.setUpdatedAt(LocalDateTime.now());

        updateExerciseInTrainings(id, dataDto);

        Exercise updatedExercise = exerciseRepository.save(exerciseToUpdate);

        return serviceMap.exerciseMapToDTO(updatedExercise);
    }

    private void updateExerciseInTrainings(String id, ExerciseDataDto dataDto) {
        List<Training> trainings = trainingRepository.findAllByExercisesId(id);
        trainings.forEach(training -> {
            training.getExercises().stream()
                    .filter(exercise -> exercise.getId().equals(id))
                    .findFirst()
                    .ifPresent(exercise -> {
                        BeanUtils.copyProperties(dataDto, exercise);
                        exercise.setUpdatedAt(LocalDateTime.now());
                    });

            training.setUpdatedAt(LocalDateTime.now());
            trainingRepository.save(training);
        });
    }


    public AllResponseDTO queryAllPageable(int pageNo, int pageSize) {
        Page<Exercise> exercises = exerciseRepository.findAll(PageRequest.of(pageNo, pageSize));

        List<ExerciseResponseDto> content = exercises.getContent().stream()
                .map(serviceMap::exerciseMapToDTO)
                .collect(Collectors.toList());

        return serviceMap.mapToResponseAll(content, exercises);
    }

    private Exercise verifyExerciseById(String id) {
        return exerciseRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Exercise not found"));
    }

    private Exercise createNewExercise(ExerciseDataDto exercise){
        return new Exercise(
                exercise.name(),
                exercise.resume(),
                exercise.category(),
                exercise.muscleWork(),
                exercise.videoOrImage(),
                exercise.description()
        );
    }



}
