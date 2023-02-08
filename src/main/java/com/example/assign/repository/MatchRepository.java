package com.example.assign.repository;

import com.example.assign.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MatchRepository extends JpaRepository<Match, Long> {
    Optional<Match>findMatchByMatchId(String matchId);
    boolean existsMatchByMatchId(String matchId);
}
