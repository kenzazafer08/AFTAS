package com.example.aftas.services.implementation;

import com.example.aftas.dto.HuntingReq;
import com.example.aftas.dto.HuntingResp;
import com.example.aftas.dto.RankingReq;
import com.example.aftas.entity.*;
import com.example.aftas.exception.ResourceNotFoundException;
import com.example.aftas.repository.*;
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
    private final CompetitionRepository competitionRepository;
    private final FishRepository fishRepository;
    private final MemberRepository memberRepository;
    private final RankingRepository rankingRepository;


    @Autowired
    public HuntingService(HuntingRepository huntingRepository, ModelMapper modelMapper, CompetitionRepository competitionRepository, FishRepository fishRepository, MemberRepository memberRepository, RankingRepository rankingRepository) {
        this.huntingRepository = huntingRepository;
        this.modelMapper = modelMapper;
        this.competitionRepository = competitionRepository;
        this.fishRepository = fishRepository;
        this.memberRepository = memberRepository;
        this.rankingRepository = rankingRepository;
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
        Hunting huntingToSave = modelMapper.map(hunting , Hunting.class);
        Competition competition = competitionRepository.findById(hunting.getCompetition()).orElseThrow(() -> new ResourceNotFoundException("Invalid competition Code"));
        Member member = memberRepository.findById(hunting.getMember()).orElseThrow(() -> new ResourceNotFoundException("Invalid Member code"));
        Fish fish = fishRepository.findById(hunting.getFish()).orElseThrow(() -> new ResourceNotFoundException("Invalid Fish code"));
        RankingId rankingId = new RankingId(competition.getCode(), member.getNum());
        rankingRepository.findById(rankingId).orElseThrow(()-> new ResourceNotFoundException("This member : "+ member.getName() + member.getFamilyName()+" is not registered in this competition" + competition.getCode()));
        Optional<Hunting> huntingFound = huntingRepository.findByCompetitionAndFishAndMember(competition , fish ,member);
        if(huntingFound.isPresent()){
            int number = huntingFound.get().getNumberOfFish();
            huntingFound.get().setNumberOfFish(number + huntingToSave.getNumberOfFish());
            huntingRepository.save(huntingFound.get());
            return Optional.of(modelMapper.map(huntingFound , HuntingResp.class));
        }else{
            huntingToSave.setFish(fish);
            huntingToSave.setMember(member);
            huntingToSave.setCompetition(competition);
            huntingRepository.save(huntingToSave);
            return Optional.of(modelMapper.map(huntingToSave , HuntingResp.class));
        }
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
