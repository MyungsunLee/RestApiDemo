package com.lms.restapidemo.board;

import com.lms.restapidemo.board.boardRegistDto.BoardRegistRequest;
import com.lms.restapidemo.board.boardRegistDto.BoardRegistResponse;
import com.lms.restapidemo.board.service.BoardsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boards")
public class BoardController {

  BoardsService boardsService;

  public BoardController(BoardsService boardsService) {
    this.boardsService = boardsService;
  }

  @PostMapping("/")
  public ResponseEntity createBoard(@RequestBody BoardRegistRequest boardRegistRequest) {

    BoardRegistResponse boardRegistResponse = boardsService.createBoard(boardRegistRequest);
    return new ResponseEntity(boardRegistResponse, HttpStatus.OK);
  }

}
