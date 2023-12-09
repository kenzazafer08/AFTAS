package com.example.aftas.services.implementation;

import com.example.aftas.dto.CompetitionReq;
import com.example.aftas.dto.CompetitionResp;
import com.example.aftas.entity.Competition;
import com.example.aftas.repository.CompetitionRepository;
import com.example.aftas.services.interfaces.CompetitionServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CompetitionService implements CompetitionServiceInterface {

    private final CompetitionRepository competitionRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CompetitionService(CompetitionRepository competitionRepository, ModelMapper modelMapper) {
        this.competitionRepository = competitionRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public Optional<CompetitionResp> AddCompetition(CompetitionReq competition) {
        Competition competitionToSave = modelMapper.map(competition , Competition.class);
        LocalDate currentDate = LocalDate.now();
        LocalDate minDate = currentDate.plusDays(2);
        if (competitionToSave.getDate().isBefore(minDate)) {
            throw new IllegalArgumentException("Date should be at least 48 hours from now");
        }else{
            if(competitionRepository.existsById(competitionToSave.getCode())){
                throw new IllegalArgumentException("Code must be unique");
            }else{
                competitionRepository.save(competitionToSave);
                return Optional.of(modelMapper.map(competitionToSave, CompetitionResp.class));
            }
        }
    }

    @Override
    public Optional<CompetitionResp> findById(String code) {
        return Optional.empty();
    }

    @Override
    public List<CompetitionResp> getAllCompetitions(int page, int size) {
        return null;
    }

    @Override
    public Optional<CompetitionResp> updateCompetition(String competitionCode, CompetitionReq competition) {
        return Optional.empty();
    }

    @Override
    public Optional<CompetitionResp> deleteCompetition(String code) {
        return Optional.empty();
    }
}
