package com.example.assign.util;

import com.example.assign.dto.riotDto.match.ParticipantsDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AverageCalculator {
    int totalKills=0;
    int totalDeath=0;
    int totalAssist=0;
    int totalGoldEarned=0;
    int totalVisionScore=0;
    int totalKills2=0;
    int totalDeath2=0;
    int totalAssist2=0;
    int totalGoldEarned2=0;
    int totalVisionScore2=0;

    int AveKills = 0;
    int AveDeath = 0;
    int AveAssist = 0;
    int AveVisionScore = 0;
    int AveGoldEarn = 0;
    int AveKills2 = 0;
    int AveDeath2 = 0;
    int AveAssist2 = 0;
    int AveVisionScore2 = 0;
    int AveGoldEarn2 = 0;

    public void addTeam1(ParticipantsDto participantsDto){
        this.totalKills += participantsDto.kills();
        this.totalDeath+=participantsDto.deaths();
        this.totalAssist+=participantsDto.assists();
        this.totalVisionScore+=participantsDto.visionScore();
        this.totalGoldEarned+=participantsDto.goldEarned();
    }
    public void addTeam2(ParticipantsDto participantsDto){
        this.totalKills2 += participantsDto.kills();
        this.totalDeath2+=participantsDto.deaths();
        this.totalAssist2+=participantsDto.assists();
        this.totalVisionScore2+=participantsDto.visionScore();
        this.totalGoldEarned2+=participantsDto.goldEarned();
    }
    public void getAve(){
        this.AveKills=totalKills/10;
        this.AveDeath=totalDeath/10;
        this.AveAssist=totalAssist/10;
        this.AveVisionScore=totalVisionScore/10;
        this.AveGoldEarn=totalGoldEarned/10;
        this.AveKills2=totalKills2/10;
        this.AveDeath2=totalDeath2/10;
        this.AveAssist2=totalAssist2/10;
        this.AveVisionScore2=totalVisionScore2/10;
        this.AveGoldEarn2=totalGoldEarned2/10;

    }
}
