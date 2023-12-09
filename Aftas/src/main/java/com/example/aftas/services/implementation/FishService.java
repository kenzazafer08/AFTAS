package com.example.aftas.services.implementation;

import com.example.aftas.dto.FishReq;
import com.example.aftas.dto.FishResp;
import com.example.aftas.entity.Fish;
import com.example.aftas.entity.Level;
import com.example.aftas.repository.FishRepository;
import com.example.aftas.repository.LevelRepository;
import com.example.aftas.services.interfaces.FishServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FishService implements FishServiceInterface {

    private final FishRepository fishRepository;
    private final LevelRepository levelRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public FishService(FishRepository fishRepository, LevelRepository levelRepository, ModelMapper modelMapper) {
        this.fishRepository = fishRepository;
        this.levelRepository = levelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<FishResp> AddFish(FishReq fish) {
        Fish fishToSave = modelMapper.map(fish , Fish.class);
        if(fishRepository.existsById(fishToSave.getName())){
            throw new IllegalArgumentException("Fish name must be unique");
        }else{
            Level level = levelRepository.findById(fish.getLevel_id()).orElseThrow(() -> new IllegalArgumentException("Invalid level ID"));
            fishToSave.setLevel(level);
            fishRepository.save(fishToSave);
            return Optional.of(modelMapper.map(fishToSave, FishResp.class));
        }
    }

    @Override
    public Optional<FishResp> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<FishResp> getAllFishes(int page, int size) {
        return null;
    }

    @Override
    public Optional<FishResp> updateFish(String fishName, FishReq fish) {
        return Optional.empty();
    }

    @Override
    public Optional<FishResp> deleteFish(String name) {
        return Optional.empty();
    }
}
