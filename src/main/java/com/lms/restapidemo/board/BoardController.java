package com.lms.restapidemo.board;

import com.lms.restapidemo.board.dto.read.BoardReadRequest;
import com.lms.restapidemo.board.dto.read.BoardReadResponse;
import com.lms.restapidemo.board.dto.create.BoardRegistRequest;
import com.lms.restapidemo.board.dto.create.BoardRegistResponse;
import com.lms.restapidemo.board.service.BoardsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The type Board controller.
 */
@RestController
@RequestMapping("/boards")
public class BoardController {

  /**
   * The Boards service.
   */
  BoardsService boardsService;

  /**
   * Instantiates a new Board controller.
   *
   * @param boardsService the boards service
   */
  public BoardController(BoardsService boardsService) {
    this.boardsService = boardsService;
  }

  /**
   * Create board response entity.
   *
   * @param boardRegistRequest the board regist request
   * @return the response entity
   */
  @PutMapping("")
  public ResponseEntity createBoard(@RequestBody BoardRegistRequest boardRegistRequest) {
    BoardRegistResponse boardRegistResponse = boardsService.createBoard(boardRegistRequest);
    return new ResponseEntity(boardRegistResponse, HttpStatus.OK);
  }

  /**
   * Read board list response entity.
   *
   * @param searchCondition the search condition
   * @param title           the title
   * @param contents        the contents
   * @param pageable        the pageable
   * @return the response entity
   */
  @GetMapping("")
  public ResponseEntity readBoardList(@RequestParam String searchCondition, String title, String contents, @PageableDefault(size = 10, page = 0, sort = "createDate", direction = Sort.Direction.DESC) Pageable pageable) {

    BoardReadRequest boardReadRequest = new BoardReadRequest();
    boardReadRequest.setSearchCondition(searchCondition);
    boardReadRequest.setTitle(title);
    boardReadRequest.setContents(contents);

    Page<BoardReadResponse> boardReadResponse = boardsService.findBySearchCondition(boardReadRequest, pageable);
    return new ResponseEntity(boardReadResponse, HttpStatus.OK);
  }

  /**
   * Read board response entity.
   *
   * @param id the id
   * @return the response entity
   */
  @GetMapping("/{id}")
  public ResponseEntity readBoard(@PathVariable("id") Integer id) {
    BoardReadResponse boardReadResponse = boardsService.findById(id);
    return new ResponseEntity(boardReadResponse, HttpStatus.OK);
  }

  /**
   * Board delete response entity.
   *
   * @param id the id
   * @return the response entity
   */
  @DeleteMapping("/{id}")
  public ResponseEntity boardDelete(@PathVariable("id") Integer id) {
    boardsService.deleteById(id);
    return new ResponseEntity(null, HttpStatus.OK);
  }
}
