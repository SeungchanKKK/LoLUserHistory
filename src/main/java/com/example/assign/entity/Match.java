package com.example.assign.entity;

import com.example.assign.util.AverageCalculator;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String matchId;

    @Column
    private Integer aveKill;

    @Column
    private Integer aveAssist;

    @Column
    private Integer aveDeath;

    @Column
    private Integer aveGoldAttain;

    @Column
    private Integer aveVisionScore;

    @Column
    private Integer aveKill2;

    @Column
    private Integer aveAssist2;

    @Column
    private Integer aveDeath2;

    @Column
    private Integer aveGoldAttain2;

    @Column
    private Integer aveVisionScore2;

    @Column
    private long gameLast;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "matchplayer_id")
    @JsonManagedReference(value = "matchPlayer-match-FK")
    private List<MatchPlayer> matchPlayers = new ArrayList<>();

    @Builder
    public Match(Long id,String matchId, Integer aveKill, Integer aveAssist, Integer aveDeath, Integer aveGoldAttain, Integer aveVisionScore, Integer aveKill2, Integer aveAssist2, Integer aveDeath2, Integer aveGoldAttain2, Integer aveVisionScore2, long gameLast, List<MatchPlayer> matchPlayers) {
        this.id = id;
        this.matchId = matchId;
        this.aveKill = aveKill;
        this.aveAssist = aveAssist;
        this.aveDeath = aveDeath;
        this.aveGoldAttain = aveGoldAttain;
        this.aveVisionScore = aveVisionScore;
        this.aveKill2 = aveKill2;
        this.aveAssist2 = aveAssist2;
        this.aveDeath2 = aveDeath2;
        this.aveGoldAttain2 = aveGoldAttain2;
        this.aveVisionScore2 = aveVisionScore2;
        this.gameLast = gameLast;
        this.matchPlayers = matchPlayers;
    }

    public void getAveValue(AverageCalculator averageCalculator){
        this.aveKill = averageCalculator.getAveKills();
        this.aveAssist = averageCalculator.getAveAssist();
        this.aveDeath = averageCalculator.getAveDeath();
        this.aveGoldAttain = averageCalculator.getAveGoldEarn();
        this.aveVisionScore = averageCalculator.getAveVisionScore();
        this.aveKill2 = averageCalculator.getAveKills2();
        this.aveAssist2 = averageCalculator.getAveAssist2();
        this.aveDeath2 = averageCalculator.getAveDeath2();
        this.aveGoldAttain2 = averageCalculator.getAveGoldEarn2();
        this.aveVisionScore2 = averageCalculator.getAveVisionScore2();
    }

    public void addPlayers(List<MatchPlayer>matchPlayers){
        this.matchPlayers =matchPlayers;
    }
}
