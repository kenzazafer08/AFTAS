package com.example.aftas.services.interfaces;

import com.example.aftas.dto.HuntingReq;
import com.example.aftas.dto.HuntingResp;

import java.util.List;
import java.util.Optional;

public interface HuntingServiceInterface {
    List<HuntingResp> getAllHunts();

    Optional<HuntingResp> getHuntingByCode(String huntingCode);

    List<HuntingResp> getHuntByCompetition(String competitionCode);

    List<HuntingResp> getHuntByMember(Long memberCode);

    List<HuntingResp> getHuntByFish(String fishName);

    Optional<HuntingResp> createHunting(HuntingReq hunting);

    Optional<HuntingResp> updateHunting(Long code ,HuntingReq hunting);

    Optional<HuntingResp> deleteHunting(Long code);

}
