package com.example.assign.service;

import com.example.assign.dto.riotDto.match.MatchDto;
import com.example.assign.dto.riotDto.match.ParticipantsDto;
import com.example.assign.entity.Match;
import com.example.assign.entity.MatchPlayer;
import com.example.assign.repository.MatchPlayerRepository;
import com.example.assign.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MatchService {
    private final RiotApiService riotApiService;
    private final MatchRepository matchRepository;
    private final MatchPlayerRepository matchPlayerRepository;
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
        Match match = Match.builder()
                .matchId(matchId)
                .summoner()
                .aveKill()
                .aveDeath()
                .aveAssist()
                .aveGoldAttain()
                .aveVisionScore()
                .gameLast()
                .build();
        List<ParticipantsDto> participantsDto = matchDto.info().participants();
        for(ParticipantsDto participant:participantsDto){
            MatchPlayer matchPlayer =MatchPlayer.builder()
                    .summonerName(participant.summonerName())
                    .teamId(participant.teamId())
                    .kill(participant.kills())
                    .death(participant.deaths())
                    .assist(participant.deaths())
                    .visionScore(participant.visionScore())
                    .champion(participant.championName())
                    .win(participant.win())
                    .goldAttain(participant.goldEarned())
                    .match()
                    .lane(participant.lane())
                    .build();
        }
        System.out.println(matchDto);
    }
}
