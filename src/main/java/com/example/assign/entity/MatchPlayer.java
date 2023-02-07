package com.example.assign.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class MatchPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String summonerName;

    @Column
    private int teamId;

    @Column
    private boolean win;

    @ManyToOne
    @JoinColumn(name = "matchId")
    @JsonBackReference(value = "")
    private Match match;

    @Column
    private int kill;

    @Column
    private int Assist;

    @Column
    private int Death;

    @Column
    private int GoldAttain;

    @Column
    private int VisionScore;

    @Column
    private String champion;

    @Column
    private String lane;

    @Builder
    public MatchPlayer(Long id, String summonerName, int teamId, boolean win, Match match, Integer kill, Integer assist, Integer death, Integer goldAttain, Integer visionScore, String champion, String lane) {
        this.id = id;
        this.summonerName = summonerName;
        this.teamId = teamId;
        this.win = win;
        this.match = match;
        this.kill = kill;
        this.Assist = assist;
        this.Death = death;
        this.GoldAttain = goldAttain;
        this.VisionScore = visionScore;
        this.champion = champion;
        this.lane = lane;
    }

}
