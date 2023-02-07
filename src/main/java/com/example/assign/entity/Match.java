package com.example.assign.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
}
