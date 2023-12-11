package com.example.aftas.services.interfaces;

import com.example.aftas.dto.RankingReq;
import com.example.aftas.dto.RankingResp;
import com.example.aftas.entity.Competition;
import com.example.aftas.entity.Ranking;
import com.example.aftas.entity.RankingId;

import java.util.List;
import java.util.Optional;

public interface RankingServiceInterface {
    Optional<RankingResp> saveRanking(RankingReq ranking);

    List<RankingResp> getRankingsByCompetitionCode(String competitionCode);

    List<RankingResp> getRankingsByMemberNumber(Long memberNumber);

    void calculateAndSetRankings(Competition competition);

    List<RankingResp> getPodiumByCompetitionCode(String competitionCode);

    List<RankingResp> updateRankings(List<RankingReq> rankings);

    Optional<RankingResp> deleteRankingById(RankingId id);

    boolean validateRanking(String competition);

}
