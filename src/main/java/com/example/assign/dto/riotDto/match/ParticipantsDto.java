package com.example.assign.dto.riotDto.match;

import java.util.List;

public record ParticipantsDto(

	String puuid,
	String summonerName,
	int teamId,
	String championName,
	String lane,
	int kills,
	int deaths,
	int assists,
	boolean win,
	List<TeamsDto> teams

) {
}
