package com.example.aftas.services.implementation;

import com.example.aftas.dto.MemberReq;
import com.example.aftas.dto.MemberResp;
import com.example.aftas.entity.Member;
import com.example.aftas.repository.MemberRepository;
import com.example.aftas.services.interfaces.MemberServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService implements MemberServiceInterface {

    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MemberService(MemberRepository memberRepository, ModelMapper modelMapper) {
        this.memberRepository = memberRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<MemberResp> AddMember(MemberReq member) {
        Member memberToSave = modelMapper.map(member , Member.class);
        LocalDate currentDate = LocalDate.now();
        memberToSave.setAccessionDate(currentDate);
        Member memberSaved = memberRepository.save(memberToSave);
        return Optional.of(modelMapper.map(memberSaved,MemberResp.class));
    }

    @Override
    public Optional<MemberResp> findById(Long num) {
        return Optional.empty();
    }

    @Override
    public List<MemberResp> getAllMembers(int page, int size) {
        return null;
    }

    @Override
    public Optional<MemberResp> updateMember(Long memberNum, MemberReq level) {
        return Optional.empty();
    }

    @Override
    public Optional<MemberResp> deleteMember(Long num) {
        return Optional.empty();
    }
}
