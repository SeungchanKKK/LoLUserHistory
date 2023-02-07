package com.example.assign.controller;

import com.example.assign.dto.returnDto.ReturnRecord20Dto;
import com.example.assign.facade.Datafacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class SummonerController {

    private final Datafacade datafacade;
    //20게임 전적호출
    @GetMapping("/summoner/{summonerName}")
    public ResponseEntity<ReturnRecord20Dto> record20Summoner(@PathVariable String summonerName) {
        return ResponseEntity.ok(datafacade.get20Data(summonerName));
    }
}
