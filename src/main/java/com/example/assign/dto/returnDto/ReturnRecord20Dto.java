package com.example.assign.dto.returnDto;

import com.example.assign.entity.Summoner;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@RequiredArgsConstructor
public class ReturnRecord20Dto {

    String summonerName;
    String winRate;
    String aveScore;
    float aveKills;
    float aveDeath;
    float aveAssist;
    List<ReturnRecordDto>returnRecordDtos= new ArrayList<>();

}
