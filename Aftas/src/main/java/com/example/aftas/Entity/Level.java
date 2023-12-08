package com.example.aftas.Entity;

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
    private int id;

    private String description;
    private int point;

    @OneToMany(mappedBy = "level", fetch = FetchType.EAGER)
    private List<Fish> fishes;
}
