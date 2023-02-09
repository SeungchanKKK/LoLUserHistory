package com.example.assign.dto.returnDto;

import com.example.assign.entity.MatchPlayer;
import com.example.assign.util.VisonGoldKDA;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class ReturnRecordDto {
    String champion;
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

    public ReturnRecordDto(List<MemberDto> teams, MatchPlayer player, VisonGoldKDA visonGoldKDA) {
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
