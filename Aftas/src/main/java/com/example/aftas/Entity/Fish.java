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
public class Fish {
    @Id
    private String name;

    private float averageWeight;

    @ManyToOne
    private Level level;

    @OneToMany(mappedBy = "fish", fetch = FetchType.EAGER)
    private List<Hunting> hunts;
}
