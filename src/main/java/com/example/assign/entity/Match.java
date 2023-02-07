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
    private String gameLast;

    @Column
    @OneToMany(mappedBy = "match")
    @JsonManagedReference(value = "matchPlayer-match-FK")
    private List<MatchPlayer> matchPlayers;

    @Builder
    public Match(Long id, Summoner summoner, Integer aveKill, Integer aveAssist, Integer aveDeath, Integer aveGoldAttain, Integer aveVisionScore, String gameLast, List<MatchPlayer> matchPlayers) {
        this.id = id;
        this.summoner = summoner;
        this.aveKill = aveKill;
        this.aveAssist = aveAssist;
        this.aveDeath = aveDeath;
        this.aveGoldAttain = aveGoldAttain;
        this.aveVisionScore = aveVisionScore;
        this.gameLast = gameLast;
        this.matchPlayers = matchPlayers;
    }
}
