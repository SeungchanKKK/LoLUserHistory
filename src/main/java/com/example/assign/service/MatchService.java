package com.example.assign.service;

import com.example.assign.dto.riotDto.match.MatchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MatchService {
    private final RiotApiService riotApiService;
    //puuid 의 소환사의 20게임을 저장하는 로직입니다.
    public void saveMatch20(String puuid){
        //Summoner 기준으로 Matchid List를 가져오는 api 호출
        List<String>matchIdList = riotApiService.getMatchIdList(puuid);

        for (String matchId : matchIdList){
            saveMatch(matchId);
        }
    }
    //matchid 로 match 데이터를 저장하는로직입니다
    public void saveMatch(String matchId){
        MatchDto matchDto = riotApiService.getMatchData(matchId);

        System.out.println(matchDto);
    }
}
