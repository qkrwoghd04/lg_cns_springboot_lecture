package board.service;

import org.springframework.stereotype.Service;

import board.dto.JoinDto;

@Service
public interface JoinService {
	boolean joinProcess(JoinDto joinDto);
}
