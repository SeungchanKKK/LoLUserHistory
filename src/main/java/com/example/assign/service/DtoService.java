package com.example.assign.service;

import com.example.assign.dto.returnDto.MemberDto;
import com.example.assign.dto.returnDto.ReturnRecord20Dto;
import com.example.assign.dto.returnDto.ReturnRecordDto;
import com.example.assign.entity.Match;
import com.example.assign.entity.MatchPlayer;
import com.example.assign.entity.Summoner;
import com.example.assign.repository.MatchRepository;
import com.example.assign.util.AverageCalculator;
import com.example.assign.util.RatingCalculator;
import com.example.assign.util.TimeCalculator;
import com.example.assign.util.VisonGoldKDA;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DtoService {

    private final RatingCalculator ratingCalculator;

    public ReturnRecord20Dto getReturn20(Summoner summoner) {
        List<ReturnRecordDto> recordDtos = new ArrayList<>();
        List<Match> matches = summoner.getMatchList();
        matches.sort(Collections.reverseOrder());
        AverageCalculator averageCalculator = new AverageCalculator();
        for (Match match : matches) {
            List<MemberDto> members = new ArrayList<>();
            for (MatchPlayer player : match.getMatchPlayers()) {
                members.add(new MemberDto(player.getSummonerName(), player.getChampion(), player.getTeamId()));
            }
            MatchPlayer player = match.findSummoner(summoner.getSummonerName());
            VisonGoldKDA visonGoldKDA = ratingCalculator.rating(match, player);
            averageCalculator.addMatchAve(visonGoldKDA, player);
            recordDtos.add(new ReturnRecordDto(match,members, player, visonGoldKDA));
        }
        averageCalculator.getMatchAve();
        return new ReturnRecord20Dto(summoner.getSummonerName(), averageCalculator, recordDtos);
    }
}
