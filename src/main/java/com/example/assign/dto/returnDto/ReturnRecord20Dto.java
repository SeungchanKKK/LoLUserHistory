package com.example.assign.dto.returnDto;

import com.example.assign.entity.Summoner;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class ReturnRecord20Dto {
    public ReturnRecord20Dto(Summoner summoner, int matchcnt) {
        this.summoner = summoner;
        this.matchcnt = matchcnt;
    }

    Summoner summoner;
    int matchcnt;
}
