package com.example.aftas.repository;

import com.example.aftas.entity.Fish;
import com.example.aftas.entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FishRepository extends JpaRepository<Fish, String> {
    List<Fish> findByLevel(Level level);
}
