package com.br.apiheath.api.controller;

import com.br.apiheath.api.dtoGeneral.*;
import com.br.apiheath.domain.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.collec.utils.Constants.DEFAULT_PAGE_NUMBER;
import static br.com.collec.utils.Constants.DEFAULT_PAGE_SIZE;

@RestController
@RequestMapping("/training")
public class TrainingController {

    @Autowired
    TrainingService trainingService;

    @PostMapping
    public ResponseEntity<TrainingResponseDto> createTraining(@RequestBody TrainingDataDto training) {
        return new ResponseEntity<>(trainingService.createTraining(training), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<AllResponseDTO> listAllExercise(@RequestParam( defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                                                          @RequestParam( defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize)
    {
        return new ResponseEntity<>(trainingService.trainingQueryAllPageable(pageNo, pageSize), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainingResponseDto> getById(@PathVariable String id ){
        return new ResponseEntity<>(trainingService.listById(id), HttpStatus.OK);
    }

    @PutMapping("/add/{trainingId}")
    public ResponseEntity<TrainingResponseDto> addExerciseToTraining(@PathVariable String trainingId,
                                                                     @RequestBody List<String> exerciseIds)
    {
        return new ResponseEntity<>(trainingService.addExerciseToTraining(trainingId, exerciseIds), HttpStatus.OK);
    }

    @PutMapping("/remove/{trainingId}/{exerciseId}")
    public ResponseEntity<TrainingResponseDto> removeExerciseToTraining(@PathVariable String trainingId,
                                                                        @PathVariable String exerciseId)
    {
        return new ResponseEntity<>(trainingService.removeExerciseToTraining(trainingId, exerciseId), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrainingResponseDto> updateTraining(@PathVariable String id,
                                                              @RequestBody TrainingDataDto dataDto)
    {
        return new ResponseEntity<>(trainingService.updateTraining(id, dataDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable String id){
        trainingService.deleteById(id);

        return "Success";
    }
}
