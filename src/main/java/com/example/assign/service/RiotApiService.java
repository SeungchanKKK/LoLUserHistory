package com.example.assign.service;

import com.example.assign.dto.riotDto.SummonerDto;
import com.example.assign.error.ExternalApiCallException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RiotApiService {
    @Value("${riot.api.key}")
    private String API_KEY;
    private static final String SUMMONER_DATA_RIOT_URL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
    private static final String MATCH_ID_RIOT_URL = "https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/";

    public SummonerDto getSummonerData(String summonerName) {
        String url = SUMMONER_DATA_RIOT_URL + summonerName + "?api_key=" + API_KEY;
        return new RestTemplate().getForObject(url, SummonerDto.class);
    }

    public List<String> getMatchIdList(String puuid) {
        try {
            String url = MATCH_ID_RIOT_URL + puuid + "/ids?start=0&count=20" + "&&api_key=" + API_KEY;

            return new RestTemplate()
                    .exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {
                    })
                    .getBody();

        } catch (Exception e) {
            throw new ExternalApiCallException(e.getMessage());
        }
    }
}
