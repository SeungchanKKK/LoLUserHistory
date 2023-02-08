package com.example.assign.dto.returnDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class ReturnRecordDto {
    int kill;
    int death;
    int assist;
    List<MemberDto> teams= new ArrayList<>();
    boolean win;
    int KDAScore;
    int VisionScore;
    int GoldScore;
    float totalScore;
}
