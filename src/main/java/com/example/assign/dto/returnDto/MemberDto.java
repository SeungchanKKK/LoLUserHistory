package com.example.assign.dto.returnDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemberDto {

    String name;
    String champion;

    public MemberDto(String name, String champion) {
        this.name = name;
        this.champion = champion;
    }
}
