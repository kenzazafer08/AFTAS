package com.example.aftas.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompetitionReq {
    @NotNull(message = "Code is required")
    private String code;
    @NotNull(message = "Date is required")
    private LocalDate Date;
    @NotNull(message = "Start time is required")
    private LocalTime startTime;
    @NotNull(message = "End time is required")
    private LocalTime endTime;
    @NotNull
    @Min(value= 4 , message = "Number of participants must be greater then 3")
    private int numberOfParticipants;
    @NotNull(message = "Location is required")
    private String location;
    @NotNull
    @Min(value=0 , message = "Amount should be a positive value")
    private float amount;
}
