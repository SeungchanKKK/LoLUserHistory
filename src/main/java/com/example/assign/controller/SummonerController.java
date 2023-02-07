package com.example.assign.controller;

import com.example.assign.facade.Datafacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class SummonerController {
    @GetMapping("/summoner/{summonerName}")
    public ResponseEntity<?> record20Summoner(@PathVariable String summonerName) {
        return ResponseEntity.ok(Datafacade.get20Data(summonerName));
    }
}
