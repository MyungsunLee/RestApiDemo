package com.lms.restapidemo.board;

import com.lms.restapidemo.board.boardReadDto.BoardReadRequest;
import com.lms.restapidemo.board.boardReadDto.BoardReadResponse;
import com.lms.restapidemo.board.boardRegistDto.BoardRegistRequest;
import com.lms.restapidemo.board.boardRegistDto.BoardRegistResponse;
import com.lms.restapidemo.board.service.BoardsService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {

  BoardsService boardsService;

  public BoardController(BoardsService boardsService) {
    this.boardsService = boardsService;
  }

  @PutMapping("/")
  public ResponseEntity createBoard(@RequestBody BoardRegistRequest boardRegistRequest) {
    BoardRegistResponse boardRegistResponse = boardsService.createBoard(boardRegistRequest);
    return new ResponseEntity(boardRegistResponse, HttpStatus.OK);
  }

  @PostMapping("/")
  public ResponseEntity readBoardList(@RequestBody BoardReadRequest boardReadRequest, @PageableDefault(size=10, page = 0, sort="createDate", direction = Sort.Direction.DESC) Pageable pageable) {
    List<BoardReadResponse> boardReadResponse = boardsService.findByDeleteYn(boardReadRequest.getDeleteYn(), pageable);
    return new ResponseEntity(boardReadResponse, HttpStatus.OK);
  }
  @GetMapping("/{id}")
  public ResponseEntity readBoard(@PathVariable("id") Integer id) {
    BoardReadResponse boardReadResponse = boardsService.findById(id);
    return new ResponseEntity(boardReadResponse, HttpStatus.OK);
  }

}
