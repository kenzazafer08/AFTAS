package com.example.aftas.DTO;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RankingReq {
    @NotNull(message = "Competition is required")
    private String competition;
    @NotNull(message = "Member is required")
    private String member;
    @Min(value = 0 , message = "Rank should be positive")
    private int rank;
    @Min(value = 0 , message = "Score should be positive")
    private int score;

}
