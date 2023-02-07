package com.example.assign.service;

import com.example.assign.dto.riotDto.SummonerDto;
import com.example.assign.entity.Summoner;
import com.example.assign.repository.SummonerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SummonerService {

    private final SummonerRepository summonerRepository;
    private final RiotApiService riotApiService;

    //처음 등록하는 소환사에게 puuid, encryptedid, accountid 를 담아 엔티티에 저장합니다
    public void firstEnroll(String summonerName){
        SummonerDto summonerDto = riotApiService.getSummonerData(summonerName);
        Summoner summoner = Summoner.builder()
                .summonerName(summonerName)
                .puuid(summonerDto.puuid())
                .encryptedId(summonerDto.id())
                .accountId(summonerDto.accountId())
                .build();
        summonerRepository.save(summoner);
        System.out.println(summonerDto);
    }
}
