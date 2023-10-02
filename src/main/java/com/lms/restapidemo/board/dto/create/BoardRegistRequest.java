package com.lms.restapidemo.board.dto.create;

import com.lms.restapidemo.board.entity.Boards;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardRegistRequest {


  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "BOARD_ID_SEQ")
  private Integer id;
  private String title;
  private String contents;
  @NotBlank(message = "작성자 입력 오류입니다")
  private Integer writerId;

  public Boards toEntity() {
    return Boards.builder()
      .title(title)
      .contents(contents)
//      .writerId(writerId)
      .build();
  }
}
