package com.br.apiheath.api.controller;

import com.br.apiheath.api.dtoGeneral.AllResponseDTO;
import com.br.apiheath.api.dtoGeneral.ExerciseDataDto;
import com.br.apiheath.api.dtoGeneral.ExerciseResponseDto;
import com.br.apiheath.domain.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static br.com.collec.utils.Constants.DEFAULT_PAGE_NUMBER;
import static br.com.collec.utils.Constants.DEFAULT_PAGE_SIZE;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    @Autowired
    ExerciseService exerciseService;

    @PostMapping
    public ResponseEntity<ExerciseResponseDto> createExercise(@RequestBody ExerciseDataDto exercise) {
        return new ResponseEntity<>(exerciseService.createExercise(exercise), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<AllResponseDTO> listAllExercise(@RequestParam( defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                                                          @RequestParam( defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize) {
        return new ResponseEntity<>(exerciseService.queryAllPageable(pageNo, pageSize), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExerciseResponseDto> getById(@PathVariable String id ){
        return new ResponseEntity<>(exerciseService.listById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExerciseResponseDto> updateExercise(@PathVariable String id, @RequestBody ExerciseDataDto dataDto){
        return new ResponseEntity<>(exerciseService.updateExercise(id, dataDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable String id){
        exerciseService.deleteById(id);

        return "Success";
    }
}
