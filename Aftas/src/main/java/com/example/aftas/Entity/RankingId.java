package com.example.aftas.Entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class RankingId implements Serializable {
    private String competitionCode;
    private int memberNum;
}
