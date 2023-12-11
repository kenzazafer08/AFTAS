package com.example.aftas.services.implementation;

import com.example.aftas.dto.RankingReq;
import com.example.aftas.dto.RankingResp;
import com.example.aftas.entity.Competition;
import com.example.aftas.entity.Member;
import com.example.aftas.entity.Ranking;
import com.example.aftas.entity.RankingId;
import com.example.aftas.exception.ResourceNotFoundException;
import com.example.aftas.repository.CompetitionRepository;
import com.example.aftas.repository.MemberRepository;
import com.example.aftas.repository.RankingRepository;
import com.example.aftas.services.interfaces.RankingServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RankingService implements RankingServiceInterface {

    private final RankingRepository rankingRepository;
    private final CompetitionRepository competitionRepository;
    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RankingService(RankingRepository rankingRepository, CompetitionRepository competitionRepository, MemberRepository memberRepository, ModelMapper modelMapper) {
        this.rankingRepository = rankingRepository;
        this.competitionRepository = competitionRepository;
        this.memberRepository = memberRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public Optional<RankingResp> saveRanking(RankingReq ranking) {
        if(validateRanking(ranking.getCompetition())){
            throw new IllegalArgumentException("Competition is closed : number of participant reached");
        }
        Competition competition = competitionRepository.findById(ranking.getCompetition()).orElseThrow(() -> new ResourceNotFoundException("Invalid competition Code"));
        Member member = memberRepository.findById(ranking.getMember()).orElseThrow(() -> new ResourceNotFoundException("Invalid Member code"));
        RankingId rankingId = new RankingId(competition.getCode(), member.getNum());
        Ranking rankingToSave = modelMapper.map(ranking , Ranking.class);
        rankingToSave.setCompetition(competition);
        rankingToSave.setMember(member);
        rankingToSave.setId(rankingId);
        Optional<Ranking> isFound = rankingRepository.findById(rankingToSave.getId());
        if(isFound.isPresent()){
            throw new IllegalArgumentException("This member : "+isFound.get().getMember().getName() + " " +isFound.get().getMember().getFamilyName() + " is already registered in the competition "+ isFound.get().getCompetition().getCode());
        }else{
            rankingRepository.save(rankingToSave);
            return Optional.of(modelMapper.map(rankingToSave , RankingResp.class));
        }
    }

    @Override
    public List<RankingResp> getRankingsByCompetitionCode(String competitionCode) {
        Competition competition = competitionRepository.findById(competitionCode).orElseThrow(() -> new ResourceNotFoundException("Invalid competition Code"));
        List<Ranking> rankings = rankingRepository.findByCompetition(competition);
        return rankings.stream().map(ranking -> modelMapper.map(ranking, RankingResp.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<RankingResp> getRankingsByMemberNumber(Long memberNumber) {
        Member member = memberRepository.findById(memberNumber).orElseThrow(() -> new ResourceNotFoundException("Invalid member Code"));
        List<Ranking> rankings = rankingRepository.findByMember(member);
        return rankings.stream().map(ranking -> modelMapper.map(ranking, RankingResp.class))
                .collect(Collectors.toList());
    }

    @Override
    public void calculateAndSetRankings(Competition competition) {

    }

    @Override
    public List<RankingResp> getPodiumByCompetitionCode(String competitionCode) {
        return null;
    }

    @Override
    public List<RankingResp> updateRankings(List<RankingReq> rankings) {
        return null;
    }

    @Override
    public Optional<RankingResp> deleteRankingById(RankingId id) {
        return Optional.empty();
    }

    @Override
    public boolean validateRanking(String competitionCode) {
        Competition competition = competitionRepository.findById(competitionCode).orElseThrow(() -> new IllegalArgumentException("Invalid competition Code"));
        int numberOfParticipant = rankingRepository.countRankingByCompetition(competition);
        return numberOfParticipant >= competition.getNumberOfParticipants();
    }
}
