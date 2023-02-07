package com.example.assign.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MatchService {
    private final RiotApiService riotApiService;
}
