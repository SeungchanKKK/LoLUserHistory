package com.example.assign.service;

import com.example.assign.dto.riotDto.match.MatchDto;
import com.example.assign.dto.riotDto.match.ParticipantsDto;
import com.example.assign.entity.Match;
import com.example.assign.entity.MatchPlayer;
import com.example.assign.entity.Summoner;
import com.example.assign.repository.MatchPlayerRepository;
import com.example.assign.repository.MatchRepository;
import com.example.assign.repository.SummonerRepository;
import com.example.assign.util.AverageCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MatchService {
    private final RiotApiService riotApiService;
    private final MatchRepository matchRepository;
    private final MatchPlayerRepository matchPlayerRepository;

    private final SummonerRepository summonerRepository;

    //puuid 의 소환사의 20게임을 저장하는 메서드입니다.
    public void saveMatch20( Summoner summoner){
        //Summoner 기준으로 Matchid List를 가져오는 api 호출
        List<String>newmatchIdList = riotApiService.getMatchIdList(summoner.getPuuid());
        //현재 가지고있는 리스트 조회
        List<Match>currentList = summoner.getMatchList();
        List<String>exists = new ArrayList<>();
        //db에 이미 존재하는 게임은 추가하지않습니다
        for (String newmatchId:newmatchIdList){
            if(matchRepository.existsMatchByMatchId(newmatchId)){
                exists.add(newmatchId);
                Match match = matchRepository.findMatchByMatchId(newmatchId).orElseThrow(() -> new NullPointerException("경기를 찾을수없습니다"));
                if(!summoner.getMatchList().contains(match)){
                    summoner.getMatchList().add(match);
                    summonerRepository.save(summoner);
                }
            }
        }
        for(String exist: exists){
            newmatchIdList.remove(exist);
        }
        // 새로운 20게임중에 이미 가지고있는 게임들은 리스트에서 삭제
        for (Match hasList :currentList){
            if(newmatchIdList.contains(hasList.getMatchId())){
                newmatchIdList.remove(hasList.getMatchId());
            }
        }
        //새로추가해야할 게임들만 추가함
        for (String matchId : newmatchIdList){
            saveMatch(matchId,summoner);
        }
    }

    //matchid 로 match 데이터를 저장하는메서드입니다
    public void saveMatch(String matchId,Summoner summoner){
        //matchId 로 riot api 호출
        MatchDto matchDto = riotApiService.getMatchData(matchId);
        Match match = new Match(matchDto,matchId);
        matchRepository.save(match);

        AverageCalculator averageCalculator = new AverageCalculator();
        List<ParticipantsDto> participantsDto = matchDto.info().participants();
        List<MatchPlayer>matchPlayers = new ArrayList<>();
        for(ParticipantsDto participant:participantsDto){
            if(participant.teamId()==100){
                averageCalculator.addTeam1(participant);
            }else {
                averageCalculator.addTeam2(participant);
            }
            MatchPlayer matchPlayer = new MatchPlayer(participant,match);
            matchPlayers.add(matchPlayer);
            matchPlayerRepository.save(matchPlayer);
        }
        Match findMatch=matchRepository.findMatchByMatchId(matchId).orElseThrow(() -> new NullPointerException("경기를 찾을수없습니다"));
        averageCalculator.getAve();
        findMatch.getAveValue(averageCalculator);
        findMatch.addPlayers(matchPlayers);
        matchRepository.save(findMatch);
        if(summoner.getMatchList().size()>=20){
            summoner.getMatchList().remove(0);
        }
        summoner.getMatchList().add(findMatch);
        summonerRepository.save(summoner);
    }
}
