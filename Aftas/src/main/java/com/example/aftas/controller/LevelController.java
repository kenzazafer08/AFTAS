package com.example.aftas.controller;

import com.example.aftas.dto.LevelReq;
import com.example.aftas.dto.LevelResp;
import com.example.aftas.services.interfaces.LevelServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
