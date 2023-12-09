package com.example.aftas.controller;

import com.example.aftas.dto.FishReq;
import com.example.aftas.dto.FishResp;
import com.example.aftas.exception.ResourceNotFoundException;
import com.example.aftas.services.interfaces.FishServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/fishes")
public class FishController {
    private final FishServiceInterface fishService;

    @Autowired
    public FishController(FishServiceInterface fishService) {
        this.fishService = fishService;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> pointValueNotValid(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleFishNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @PostMapping("/add")
    public ResponseEntity<FishResp> AddFish(@Valid @RequestBody FishReq fish){
        Optional<FishResp> savedFish = fishService.AddFish(fish);
        return ResponseEntity.ok(savedFish.get());
    }
}
