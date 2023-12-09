package com.example.aftas.repository;

import com.example.aftas.entity.Ranking;
import com.example.aftas.entity.RankingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, RankingId> {
}
