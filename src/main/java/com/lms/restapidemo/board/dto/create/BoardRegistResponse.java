package com.lms.restapidemo.board.dto.create;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BoardRegistResponse {

  @NotNull
  private Integer id;

  @NotNull
  private String title;

  @NotNull
  private String contents;

  @NotNull
  private LocalDateTime createDate;

  @NotNull
  private LocalDateTime updateDate;

  @Builder
  public BoardRegistResponse(Integer id, String title, String contents, LocalDateTime createDate, LocalDateTime updateDate) {
    this.id = id;
    this.title = title;
    this.contents = contents;
    this.createDate = createDate;
    this.updateDate = updateDate;
  }
}
