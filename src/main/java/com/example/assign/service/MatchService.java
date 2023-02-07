package com.example.assign.service;

import com.example.assign.dto.riotDto.match.MatchDto;
import com.example.assign.dto.riotDto.match.ParticipantsDto;
import com.example.assign.entity.Match;
import com.example.assign.entity.MatchPlayer;
import com.example.assign.entity.Summoner;
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
    public void saveMatch20( Summoner summoner){
        //Summoner 기준으로 Matchid List를 가져오는 api 호출
        List<String>matchIdList = riotApiService.getMatchIdList(summoner.getPuuid());

        for (String matchId : matchIdList){
            saveMatch(matchId,summoner);
        }
    }
    //matchid 로 match 데이터를 저장하는로직입니다
    public void saveMatch(String matchId,Summoner summoner){
        MatchDto matchDto = riotApiService.getMatchData(matchId);
        Match match = Match.builder()
                .matchId(matchId)
                .summoner(summoner)
                .gameLast(matchDto.info().gameDuration())
                .build();
        matchRepository.save(match);
        int totalKills=0;
        int totalDeath=0;
        int totalAssist=0;
        int totalGoldEarned=0;
        int totalVisionScore=0;
        List<ParticipantsDto> participantsDto = matchDto.info().participants();
        for(ParticipantsDto participant:participantsDto){
            totalKills+=participant.kills();
            totalDeath+=participant.deaths();
            totalAssist+=participant.assists();
            totalGoldEarned+=participant.goldEarned();
            totalVisionScore+=participant.visionScore();
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
                    .match(match)
                    .lane(participant.lane())
                    .build();
            matchPlayerRepository.save(matchPlayer);
        }
        Match match1=matchRepository.findMatchByMatchId(matchId).orElseThrow(() -> new NullPointerException("경기를 찾을수없습니다"));
        match1.getAveValue(totalKills/10,totalAssist/10,totalDeath/10,totalGoldEarned/10,totalVisionScore/10);
        matchRepository.save(match1);
    }
}
