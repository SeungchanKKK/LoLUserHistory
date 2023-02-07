package com.example.assign.facade;

import com.example.assign.dto.returnDto.ReturnRecord20Dto;
import com.example.assign.repository.SummonerRepository;
import com.example.assign.service.RiotApiService;
import com.example.assign.service.SummonerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class Datafacade {

    private final SummonerService summonerService;

    private final SummonerRepository summonerRepository;

    public ReturnRecord20Dto get20Data(String summonerName) {
        //db에 Summoner 조회
        if (!summonerRepository.existsSummonerBySummonerName(summonerName)) {
            summonerService.firstEnroll(summonerName);
        }
        return new ReturnRecord20Dto();
    }
}
