package com.lms.restapidemo.board.boardReadDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BoardReadRequest {
  private String title;
  private String contents;
  private Integer writerId;
  private String writerName;
  private char deleteYn;

  private String searchCondition;

  @Builder
  public BoardReadRequest(String title, String contents, Integer writerId, char deleteYn, String writerName, String searchCondition) {
    this.title = title;
    this.contents = contents;
    this.writerId = writerId;
    this.deleteYn = deleteYn;
    this.writerName = writerName;
    this.searchCondition = searchCondition;
  }
}
