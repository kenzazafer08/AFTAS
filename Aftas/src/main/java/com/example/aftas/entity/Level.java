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
    private Long id;

    private String description;
    private int point;

    @OneToMany(mappedBy = "level")
    private List<Fish> fishes;
}
