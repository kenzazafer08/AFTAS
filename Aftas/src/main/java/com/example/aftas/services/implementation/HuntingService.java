package com.example.aftas.services.implementation;

import com.example.aftas.dto.HuntingReq;
import com.example.aftas.dto.HuntingResp;
import com.example.aftas.repository.HuntingRepository;
import com.example.aftas.services.interfaces.HuntingServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HuntingService implements HuntingServiceInterface {

    private final HuntingRepository huntingRepository;

    private final ModelMapper modelMapper;


    @Autowired
    public HuntingService(HuntingRepository huntingRepository, ModelMapper modelMapper) {
        this.huntingRepository = huntingRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<HuntingResp> getAllHunts() {
        return null;
    }

    @Override
    public Optional<HuntingResp> getHuntingByCode(String huntingCode) {
        return Optional.empty();
    }

    @Override
    public List<HuntingResp> getHuntByCompetition(String competitionCode) {
        return null;
    }

    @Override
    public List<HuntingResp> getHuntByMember(Long memberCode) {
        return null;
    }

    @Override
    public List<HuntingResp> getHuntByFish(String fishName) {
        return null;
    }

    @Override
    public Optional<HuntingResp> createHunting(HuntingReq hunting) {
        return Optional.empty();
    }

    @Override
    public Optional<HuntingResp> updateHunting(Long code, HuntingReq hunting) {
        return Optional.empty();
    }

    @Override
    public Optional<HuntingResp> deleteHunting(Long code) {
        return Optional.empty();
    }
}
