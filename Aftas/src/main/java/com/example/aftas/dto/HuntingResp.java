package com.example.aftas.dto;

import com.example.aftas.entity.Competition;
import com.example.aftas.entity.Fish;
import com.example.aftas.entity.Member;
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
