package com.example.aftas.controller;

import com.example.aftas.dto.RankingReq;
import com.example.aftas.dto.RankingResp;
import com.example.aftas.services.interfaces.RankingServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/Competition/{competitionCode}")
    public ResponseEntity<List<RankingResp>> getByCompetition(@PathVariable String competitionCode){
        return ResponseEntity.ok(rankingService.getRankingsByCompetitionCode(competitionCode));
    }

    @GetMapping("/Member/{memberNum}")
    public ResponseEntity<List<RankingResp>> getByMember(@PathVariable Long memberNum){
        return ResponseEntity.ok(rankingService.getRankingsByMemberNumber(memberNum));
    }
}
