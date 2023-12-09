package com.example.aftas.services.interfaces;


import com.example.aftas.dto.MemberReq;
import com.example.aftas.dto.MemberResp;

import java.util.List;
import java.util.Optional;

public interface MemberServiceInterface {
    Optional<MemberResp> AddMember(MemberReq member) ;
    Optional<MemberResp> findById(Long num);
    List<MemberResp> getAllMembers(int page, int size);
    Optional<MemberResp> updateMember(Long memberNum , MemberReq level);
    Optional<MemberResp> deleteMember(Long num);
}
