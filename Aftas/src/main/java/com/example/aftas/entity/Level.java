package com.example.aftas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private int point;

    @OneToMany(mappedBy = "level", fetch = FetchType.EAGER)
    private List<Fish> fishes;
}
