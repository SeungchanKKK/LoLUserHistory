package com.example.assign.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "summonerId")
    @JsonBackReference(value = "")
    private Summoner summoner;

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
    private long gameLast;

    @Column
    @OneToMany(mappedBy = "match")
    @JsonManagedReference(value = "matchPlayer-match-FK")
    private List<MatchPlayer> matchPlayers;

    @Builder
    public Match(Long id,String matchId, Summoner summoner, Integer aveKill, Integer aveAssist, Integer aveDeath, Integer aveGoldAttain, Integer aveVisionScore, long gameLast, List<MatchPlayer> matchPlayers) {
        this.id = id;
        this.matchId = matchId;
        this.summoner = summoner;
        this.aveKill = aveKill;
        this.aveAssist = aveAssist;
        this.aveDeath = aveDeath;
        this.aveGoldAttain = aveGoldAttain;
        this.aveVisionScore = aveVisionScore;
        this.gameLast = gameLast;
        this.matchPlayers = matchPlayers;
    }

    public void getAveValue(Integer aveKill, Integer aveAssist, Integer aveDeath, Integer aveGoldAttain, Integer aveVisionScore){
        this.aveKill = aveKill;
        this.aveAssist = aveAssist;
        this.aveDeath = aveDeath;
        this.aveGoldAttain = aveGoldAttain;
        this.aveVisionScore = aveVisionScore;
    }
}
