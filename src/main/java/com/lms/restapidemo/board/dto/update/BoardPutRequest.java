package com.lms.restapidemo.board.dto.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardPutRequest {
  // 프론트에서 받아야 하는 값들
  private Integer id;
  private String title;
  private String contents;

}
