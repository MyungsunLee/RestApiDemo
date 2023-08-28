package com.lms.restapidemo.board.boardRegistDto;

import com.lms.restapidemo.board.entity.Boards;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

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
  private Date registDate;

  @NotNull
  private Date updateDate;

  @Builder
  public BoardRegistResponse(Integer id, String title, String contents, Date registDate, Date updateDate) {
    this.id = id;
    this.title = title;
    this.contents = contents;
    this.registDate = registDate;
    this.updateDate = updateDate;
  }
}
