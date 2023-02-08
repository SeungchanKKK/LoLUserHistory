package com.example.assign.service;

import com.example.assign.dto.returnDto.MemberDto;
import com.example.assign.dto.returnDto.ReturnRecord20Dto;
import com.example.assign.dto.returnDto.ReturnRecordDto;
import com.example.assign.entity.Match;
import com.example.assign.entity.MatchPlayer;
import com.example.assign.entity.Summoner;
import com.example.assign.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DtoService {

    private final MatchRepository matchRepository;

    public ReturnRecord20Dto getReturn20 (Summoner summoner){
        ReturnRecord20Dto returnRecord20Dto = new ReturnRecord20Dto();
        List<ReturnRecordDto>recordDtos = new ArrayList<>();
        List<Match>matches = summoner.getMatchList();
        for(Match match: matches){
            ReturnRecordDto recordDto = new ReturnRecordDto();
            List<MemberDto> members = new ArrayList<>();
            List<MatchPlayer>players = match.getMatchPlayers();
            for (MatchPlayer player : players){
                members.add(new MemberDto(player.getSummonerName(), player.getChampion()));
            }
            MatchPlayer player = match.findSummoner(summoner.getSummonerName());

        }
        return null;
    }
}
