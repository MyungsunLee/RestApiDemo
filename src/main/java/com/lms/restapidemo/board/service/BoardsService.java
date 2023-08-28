package com.lms.restapidemo.board.service;

import com.lms.restapidemo.board.boardRegistDto.BoardRegistRequest;
import com.lms.restapidemo.board.boardRegistDto.BoardRegistResponse;
import com.lms.restapidemo.board.entity.Boards;
import com.lms.restapidemo.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardsService {
    public final BoardRepository boardRepository;

    public BoardRegistResponse createBoard(BoardRegistRequest boardRegistRequest) {
        Boards board = boardRegistRequest.toEntity();
        Boards result = boardRepository.save(board);
        return result.toBoardRegistResponseDto(result);
    }
}
