package com.example.assign.dto.riotDto.match;

import java.util.List;

public record InfoDto(
	String gameMode,

	long gameDuration,

	long gameCreation,
	List<ParticipantsDto> participants

) {
}
