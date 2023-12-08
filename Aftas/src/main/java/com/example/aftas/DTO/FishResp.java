package com.example.aftas.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FishResp {
    private String name;
    private float averageWeight;
    private LevelResp level;
}
