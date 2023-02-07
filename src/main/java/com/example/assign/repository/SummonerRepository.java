package com.example.assign.repository;

import com.example.assign.entity.Summoner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SummonerRepository extends JpaRepository<Summoner, Long> {
    Optional<Summoner> findSummonerBySummonerName(String summonerName);
    boolean existsSummonerBySummonerName(String summonerName);
}
