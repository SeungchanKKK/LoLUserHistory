package com.example.assign.apiTest;

import com.example.assign.dto.riotDto.SummonerDto;
import com.example.assign.service.RiotApiService;
import org.junit.jupiter.api.Test;

public class ApiTest extends RiotApiService {
    @Test
    public void SummonerDataApiTest(){
        String test_env = System.getenv("riot.api.key");
        String sum = "잼민이육학년";
        SummonerDto info = getSummonerData(sum);
        System.out.println(info);
    }
}
