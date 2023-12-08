package com.example.aftas.DTO;

import com.example.aftas.Entity.Competition;
import com.example.aftas.Entity.Fish;
import com.example.aftas.Entity.Member;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HuntingResp {
    private Long id;
    private int numberOfFish;
    private Fish fish;
    private Competition competition;
    private Member member;
}
