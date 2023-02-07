package com.example.assign.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

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
}
