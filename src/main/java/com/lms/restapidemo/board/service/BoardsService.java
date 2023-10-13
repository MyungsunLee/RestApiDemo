package com.lms.restapidemo.board.service;

import com.lms.restapidemo.board.dto.read.BoardReadRequest;
import com.lms.restapidemo.board.dto.read.BoardReadResponse;
import com.lms.restapidemo.board.dto.create.BoardRegistRequest;
import com.lms.restapidemo.board.dto.create.BoardRegistResponse;
import com.lms.restapidemo.board.entity.Boards;
import com.lms.restapidemo.board.repository.BoardRepository;
import com.lms.restapidemo.common.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.Optional;

import static com.lms.restapidemo.common.exception.ExceptionEnum.NO_SUCH_DATA_EXCEPTION;

@Service
@RequiredArgsConstructor
public class BoardsService {
    public final BoardRepository boardRepository;

    public BoardRegistResponse createBoard(BoardRegistRequest boardRegistRequest) {
        Boards board = boardRegistRequest.toEntity();
        Boards result = boardRepository.save(board);
        return result.toBoardRegistResponseDto(result);
    }


    public Page<BoardReadResponse> findBySearchCondition(BoardReadRequest boardReadRequest, Pageable pageable) {
        String searchCondition = boardReadRequest.getSearchCondition();

        Page<Boards> boardsList = null;

        if ("writerName".equals(searchCondition)) {
            // boardRepository.findBy
        } else if ("title".equals(searchCondition)) {
            boardsList = boardRepository.findByTitleContainsAndDeleteYn(boardReadRequest.getTitle(), pageable, 'N');
        } else if ("contents".equals(searchCondition)) {
            boardsList = boardRepository.findByContentsContainsAndDeleteYn(boardReadRequest.getContents(), pageable, 'N');
        }

        Page<BoardReadResponse> boardReadResponses = new BoardReadResponse().toBardReadDtoList(boardsList);
        return boardReadResponses;
    }

    public BoardReadResponse findById(Integer id) {
        Optional<Boards> board = boardRepository.findById(id);
        BoardReadResponse boardREadResponse = board.orElseThrow().toBoardReadResponeDto();
        return boardREadResponse;
    }

    public void deleteById(Integer id) {
        Optional<Boards> boards = boardRepository.findByIdAndDeleteYn(id, 'N');
        if (boards.isEmpty()) {
            throw new ApiException(NO_SUCH_DATA_EXCEPTION);
        }else {
            boards.get().setDeleteYn('Y');
            boardRepository.save(boards.get());
        }
    }

}
