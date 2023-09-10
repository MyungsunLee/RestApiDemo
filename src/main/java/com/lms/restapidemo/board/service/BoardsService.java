package com.lms.restapidemo.board.service;

import com.lms.restapidemo.board.boardReadDto.BoardReadRequest;
import com.lms.restapidemo.board.boardReadDto.BoardReadResponse;
import com.lms.restapidemo.board.boardRegistDto.BoardRegistRequest;
import com.lms.restapidemo.board.boardRegistDto.BoardRegistResponse;
import com.lms.restapidemo.board.entity.Boards;
import com.lms.restapidemo.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardsService {
    public final BoardRepository boardRepository;

    public BoardRegistResponse createBoard(BoardRegistRequest boardRegistRequest) {
        Boards board = boardRegistRequest.toEntity();
        Boards result = boardRepository.save(board);
        return result.toBoardRegistResponseDto(result);
    }


    public List<BoardReadResponse> findByDeleteYn(char deleteYn, Pageable pageable) {
        List<Boards> boardsList = boardRepository.findByDeleteYn(deleteYn, pageable);
        return boardsList.stream().map(e -> e.toBoardReadResponeDto()).toList();
    }

    public BoardReadResponse findById(Integer id) {
        Optional<Boards> board = boardRepository.findById(id);
        BoardReadResponse boardREadResponse = board.orElseThrow().toBoardReadResponeDto();
        return boardREadResponse;
    }

}
