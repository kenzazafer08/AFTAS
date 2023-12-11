package com.example.aftas.controller;

import com.example.aftas.dto.RankingReq;
import com.example.aftas.dto.RankingResp;
import com.example.aftas.services.interfaces.RankingServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/rankings")
public class RankingController {

    private final RankingServiceInterface rankingService;

    @Autowired
    public RankingController(RankingServiceInterface rankingService) {
        this.rankingService = rankingService;
    }

    @PostMapping("/add")
    public ResponseEntity<Optional<RankingResp>> addRanking(@Valid @RequestBody RankingReq ranking){
        return ResponseEntity.ok(rankingService.saveRanking(ranking));
    }
}
