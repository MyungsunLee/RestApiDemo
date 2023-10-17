package com.lms.restapidemo.board.dto.create;

import com.lms.restapidemo.board.entity.Boards;
import com.lms.restapidemo.board.entity.Comments;
import com.lms.restapidemo.member.entity.Members;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommnetRegistRequest {

  /*
  private Integer id;
  */
  private Integer boardId;
  private Integer parentId;
  private Integer level;
  private String contents;


  public Comments toEntity(Boards boards, Members members) {
    return Comments.builder()
      .boards(boards)
      .members(members)
      .parentId(parentId)
      .level(level)
      .contents(contents)
      .build();
  }

}
