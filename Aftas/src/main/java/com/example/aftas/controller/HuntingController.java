package com.example.aftas.controller;

import com.example.aftas.dto.HuntingReq;
import com.example.aftas.dto.HuntingResp;
import com.example.aftas.services.interfaces.HuntingServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hunts")
public class HuntingController {

    private final HuntingServiceInterface huntingService;

    @Autowired
    public HuntingController(HuntingServiceInterface huntingService) {
        this.huntingService = huntingService;
    }

    @PostMapping("/add")
    public ResponseEntity<Optional<HuntingResp>> addHunting(@Valid @RequestBody HuntingReq hunting){
        return ResponseEntity.ok(huntingService.createHunting(hunting));
    }

    @GetMapping("/list")
    public ResponseEntity<List<HuntingResp>> getAllHunting(){
        return ResponseEntity.ok(huntingService.getAllHunts());
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<HuntingResp>> getById(@PathVariable Long id){
        return ResponseEntity.ok(huntingService.getHuntingByCode(id));
    }

    @GetMapping("/Competition/{id}")
    public ResponseEntity<List<HuntingResp>> getHuntingByCompetition(@PathVariable String id){
        return ResponseEntity.ok(huntingService.getHuntByCompetition(id));
    }
}
