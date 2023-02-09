package com.example.assign.dto.returnDto;

import com.example.assign.entity.Match;
import com.example.assign.entity.MatchPlayer;
import com.example.assign.util.TimeCalculator;
import com.example.assign.util.VisonGoldKDA;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class ReturnRecordDto {
    String champion;

    String gameMode;

    String gameDuration;

    String timeStamp;
    int kill;
    int death;
    int assist;
    boolean win;

    float KDA;
    int KDAScore;
    int VisionScore;
    int growthScore;
    float duty;

    List<MemberDto> teams= new ArrayList<>();

    public ReturnRecordDto(Match match, List<MemberDto> teams, MatchPlayer player, VisonGoldKDA visonGoldKDA) {
        TimeCalculator timeCalculator = new TimeCalculator();
        this.gameMode =match.getGameMode();
        this.gameDuration = timeCalculator.getTimefromSec(match.getGameduration());
        this.timeStamp = timeCalculator.getTimestampToDate(match.getGameEndTimeStamp());
        this.champion = player.getChampion();
        this.kill = player.getKill();
        this.death = player.getDeath();
        this.assist = player.getAssist();
        this.teams = teams;
        this.win = player.isWin();
        this.KDA = (player.getKill()+ player.getAssist())/ (float)player.getDeath();
        this.KDAScore = visonGoldKDA.getKDAScore();
        this.VisionScore = visonGoldKDA.getVisionScore();
        this.growthScore = visonGoldKDA.getGrowthScore();
        this.duty = visonGoldKDA.getDuty();
    }
}
