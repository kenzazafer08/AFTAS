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

import java.util.Optional;

@RestController
@RequestMapping("/levels")
public class LevelController {
    private final LevelServiceInterface levelService;

    @Autowired
    public LevelController(LevelServiceInterface levelService){
        this.levelService = levelService;
    }

    @PostMapping("/add")
    public ResponseEntity<LevelResp> addLevel(@Valid @RequestBody LevelReq level) {
        Optional<LevelResp> levelSaved = levelService.AddLevel(level);
        return ResponseEntity.ok(levelSaved.get());
    }

    @GetMapping("{id}")
    public ResponseEntity<LevelResp> findById(@PathVariable Long id){
        Optional<LevelResp> level = levelService.findById(id);
        return ResponseEntity.ok(level.get());
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleLevelNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
