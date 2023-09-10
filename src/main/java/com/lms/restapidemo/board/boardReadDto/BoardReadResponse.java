package com.lms.restapidemo.board.boardReadDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BoardReadResponse {
  private Integer id;
  private String title;
  private String contents;
  private String writerName;
  private LocalDateTime createDate;
  private char deleteYn;

  @Builder
  public BoardReadResponse(Integer id, String title, String contents, String writerName, LocalDateTime createDate, char deleteYn) {
    this.id = id;
    this.title = title;
    this.contents = contents;
    this.writerName = writerName;
    this.createDate = createDate;
    this.deleteYn = deleteYn;
  }

}
