package com.example.aftas.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LevelReq {
    @NotEmpty(message = "Description is required")
    private String description;
    @NotNull
    @Min(value = 0 , message = "point should be a positive value")
    private int point;
}
