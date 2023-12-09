package com.example.aftas.repository;

import com.example.aftas.entity.Hunting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HuntingRepository extends JpaRepository<Hunting , Long> {
}
