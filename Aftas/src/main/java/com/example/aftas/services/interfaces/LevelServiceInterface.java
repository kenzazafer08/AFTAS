package com.example.aftas.services.interfaces;

import com.example.aftas.dto.LevelReq;
import com.example.aftas.dto.LevelResp;

import java.util.List;
import java.util.Optional;

public interface LevelServiceInterface {
    Optional<LevelResp> AddLevel(LevelReq level) throws Exception;
    Optional<LevelResp> findById(Long id);
    List<LevelResp> getAllLevels(int page, int size);
    Optional<LevelResp> updateLevel(LevelReq level);
    Optional<LevelResp> deleteLevel(Long id);
}
