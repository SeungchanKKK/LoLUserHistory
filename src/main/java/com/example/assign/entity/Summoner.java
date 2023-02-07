package com.example.assign.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Summoner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String summonerName;

    @Column
    private Integer win;

    @Column
    private Integer loss;

    @Column
    private String winningRate;

    @Column
    private String puuid;

    @Column
    private String encryptedId;

    @Column
    private String accountId;

    @OneToMany(mappedBy = "summoner")
    @JsonManagedReference(value = "match-summoner-FK")
    private List<Match> matchList;

    @Builder
    public Summoner(String summonerName,  String encryptedId,String accountId,String puuid) {
        Assert.hasText(summonerName, "summonerName must not be empty");
        Assert.hasText(accountId, "accountId must not be empty");
        Assert.hasText(encryptedId, "encryptedId must not be empty");
        this.summonerName = summonerName;
        this.puuid = puuid;
        this.encryptedId = encryptedId;
        this.accountId =accountId;
    }

    public void resetData(String winningRate, Integer win,Integer loss) {
        this.win = win;
        this.loss = loss;
        this.winningRate = winningRate;
    }
}
