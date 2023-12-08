package com.example.aftas.DTO;

import com.example.aftas.Entity.Competition;
import com.example.aftas.Entity.Member;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RankingResp {
    private Competition competition;
    private Member member;
    private int rank;
    private int score;
}
