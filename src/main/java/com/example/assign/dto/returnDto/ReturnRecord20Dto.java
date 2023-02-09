package com.example.assign.dto.returnDto;

import com.example.assign.util.AverageCalculator;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class ReturnRecord20Dto {

    String summonerName;
    float winRate;
    float aveDuty;
    float aveKDA;

    float aveKills;

    float aveDeath;

    float aveAssist;
    List<ReturnRecordDto>returnRecordDtos= new ArrayList<>();

    public ReturnRecord20Dto(String summonerName, AverageCalculator averageCalculator, List<ReturnRecordDto> returnRecordDtos) {
        this.summonerName = summonerName;
        this.winRate = averageCalculator.getWinningRate();
        this.aveDuty = averageCalculator.getAveScore();
        this.aveKDA = (averageCalculator.getAveKills()+averageCalculator.getAveAssist())/(float)averageCalculator.getAveDeath();
        this.aveKills= averageCalculator.getAveKills();
        this.aveDeath = averageCalculator.getAveDeath();
        this.aveAssist = averageCalculator.getAveAssist();
        this.returnRecordDtos = returnRecordDtos;
    }
}
