package com.example.aftas.services.implementation;

import com.example.aftas.dto.LevelReq;
import com.example.aftas.dto.LevelResp;
import com.example.aftas.entity.Level;
import com.example.aftas.repository.LevelRepository;
import com.example.aftas.services.interfaces.LevelServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.Optional;

@Service
public class LevelService implements LevelServiceInterface {

    private final LevelRepository levelRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public LevelService(LevelRepository levelRepository, ModelMapper modelMapper) {
        this.levelRepository = levelRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public Optional<LevelResp> AddLevel(LevelReq level) {
        Level levelToSave = modelMapper.map(level, Level.class);
        Level levelSaved = levelRepository.save(levelToSave);
        return Optional.of(modelMapper.map(levelSaved,LevelResp.class));
    }

    @Override
    public Optional<LevelResp> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<LevelResp> getAllLevels() {
        return null;
    }

    @Override
    public Optional<LevelResp> updateLevel(LevelReq level) {
        return Optional.empty();
    }

    @Override
    public Optional<LevelResp> deleteLevel(Long id) {
        return Optional.empty();
    }
}
