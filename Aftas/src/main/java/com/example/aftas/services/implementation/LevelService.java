package com.example.aftas.services.implementation;

import com.example.aftas.dto.LevelReq;
import com.example.aftas.dto.LevelResp;
import com.example.aftas.entity.Level;
import com.example.aftas.exception.ResourceNotFoundException;
import com.example.aftas.repository.LevelRepository;
import com.example.aftas.services.interfaces.LevelServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public Optional<LevelResp> AddLevel(LevelReq level) throws Exception {

        boolean found = false;

        Level levelToSave = modelMapper.map(level, Level.class);

        List<Level> lowerIdLevels = levelRepository.findAll();

        for (Level lowerIdLevel : lowerIdLevels) {
            if (levelToSave.getPoint() <= lowerIdLevel.getPoint()) {
                found = true;
                break;
            }
        }
        if(found){
            throw new IllegalArgumentException("Points should be higher than existing levels with lower IDs.");
        }else{
            Level levelSaved = levelRepository.save(levelToSave);
            return Optional.of(modelMapper.map(levelSaved,LevelResp.class));
        }
    }

    @Override
    public Optional<LevelResp> findById(Long id) {
        Optional<Level> level = levelRepository.findById(id);
        if(level.isPresent()){
            return Optional.of(modelMapper.map(level,LevelResp.class));
        }else{
            throw new ResourceNotFoundException("Level not found with ID : " + id);
        }
    }

    @Override
    public List<LevelResp> getAllLevels(int page, int size) {
        Page<Level> levelsPage = levelRepository.findAll(PageRequest.of(page, size));
        List<Level> levels = levelsPage.getContent();
        return levels.stream()
                .map(level -> modelMapper.map(level, LevelResp.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<LevelResp> updateLevel(LevelReq level) {
        return Optional.empty();
    }

    @Override
    public Optional<LevelResp> deleteLevel(Long id) {
        Optional<Level> level = levelRepository.findById(id);
        if(level.isPresent()){
            levelRepository.delete(level.get());
            return Optional.of(modelMapper.map(level,LevelResp.class));
        }else{
            throw new ResourceNotFoundException("Level not found with ID : " + id);
        }
    }
}
