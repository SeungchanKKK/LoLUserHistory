package com.example.assign.dto.returnDto;

import com.example.assign.entity.MatchPlayer;
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
    List<MemberDto> teams= new ArrayList<>();
    boolean win;

    float KDA;
    int KDAScore;
    int VisionScore;
    int GoldScore;
    float totalScore;

    public ReturnRecordDto(List<MemberDto> teams, MatchPlayer player) {
        this.champion = player.getChampion();
        this.kill = player.getKill();
        this.death = player.getDeath();
        this.assist = player.getAssist();
        this.teams = teams;
        this.win = player.isWin();
        this.KDA = getKDA();
        this.KDAScore = KDAScore;
        this.VisionScore = visionScore;
        this.GoldScore = goldScore;
        this.totalScore = totalScore;
    }
}
