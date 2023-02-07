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
