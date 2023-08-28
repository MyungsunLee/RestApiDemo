package com.lms.restapidemo.board.boardRegistDto;

import com.lms.restapidemo.board.entity.Boards;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardRegistRequest {

  public String title;
  public String contents;
  @NotBlank(message = "작성자 입력 오류입니다")
  public Integer writerId;

  public Boards toEntity() {
    return Boards.builder()
      .title(title)
      .contents(contents)
      .writerId(writerId)
      .build();
  }
}
