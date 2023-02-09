package com.example.assign.dto.returnDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemberDto {

    String name;
    String champion;

    int team;

    public MemberDto(String name, String champion,int team) {
        this.name = name;
        this.champion = champion;
        this.team =team;
    }
}
