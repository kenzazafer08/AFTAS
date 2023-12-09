package com.example.aftas.controller;

import com.example.aftas.dto.LevelReq;
import com.example.aftas.dto.LevelResp;
import com.example.aftas.exception.ResourceNotFoundException;
import com.example.aftas.services.interfaces.LevelServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/levels")
public class LevelController {
    private final LevelServiceInterface levelService;

    @Autowired
    public LevelController(LevelServiceInterface levelService){
        this.levelService = levelService;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> pointValueNotValid(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleLevelNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @PostMapping("/add")
    public ResponseEntity<Optional<LevelResp>> addLevel(@Valid @RequestBody LevelReq level) throws Exception {
        Optional<LevelResp> levelSaved = levelService.AddLevel(level);
        return ResponseEntity.ok(levelSaved);
    }

    @GetMapping("{id}")
    public ResponseEntity<LevelResp> findById(@PathVariable Long id){
        Optional<LevelResp> level = levelService.findById(id);
        return ResponseEntity.ok(level.get());
    }

    @GetMapping("/list")
    public ResponseEntity<List<LevelResp>> getAllLevels(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        List<LevelResp> Levels = levelService.getAllLevels(page,size);
        return ResponseEntity.ok(Levels);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<LevelResp>> deleteLevel(@PathVariable Long id){
        Optional<LevelResp> level = levelService.deleteLevel(id);
        return ResponseEntity.ok(level);
    }

    @PutMapping("/update/{levelCode}")
    public ResponseEntity<Optional<LevelResp>> updateLevel(
            @PathVariable Long levelCode,
            @Valid @RequestBody LevelReq level
    ){
        Optional<LevelResp> updatedLevel = levelService.updateLevel(levelCode,level);
        return ResponseEntity.ok(updatedLevel);
    }

}
