package com.example.assign.facade;

import com.example.assign.dto.returnDto.ReturnRecord20Dto;
import com.example.assign.repository.SummonerRepository;
import com.example.assign.service.SummonerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Datafacade {

    private final SummonerService summonerService;

    private final SummonerRepository summonerRepository;

    public ReturnRecord20Dto get20Data(String summonerName) {
        //db에 Summoner 조회후 summoner 가 없을시 , 즉 첫조회일때 db에 객체 저장
        if (!summonerRepository.existsSummonerBySummonerName(summonerName)) {
            summonerService.firstEnroll(summonerName);
        }
        return new ReturnRecord20Dto();
    }
}
