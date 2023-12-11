package com.example.aftas.controller;

import com.example.aftas.dto.HuntingReq;
import com.example.aftas.dto.HuntingResp;
import com.example.aftas.services.interfaces.HuntingServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
