package com.lms.restapidemo.board.dto.read;

import com.lms.restapidemo.board.entity.Boards;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

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
  private String deleteYn;

  @Builder
  public BoardReadResponse(Integer id, String title, String contents, String writerName, LocalDateTime createDate, String deleteYn) {
    this.id = id;
    this.title = title;
    this.contents = contents;
    this.writerName = writerName;
    this.createDate = createDate;
    this.deleteYn = deleteYn;
  }

  /* Page<Entity> -> Page<Dto> 변환처리 */
  public Page<BoardReadResponse> toBardReadDtoList(Page<Boards> boardList){
    Page<BoardReadResponse> boardDtoList = boardList.map(m -> BoardReadResponse.builder()
      .id(m.getId())
      .title(m.getTitle())
      .contents(m.getContents())
      .writerName(m.getMembers().getMemberName())
      .createDate(m.getCreateDate())
      .build());
    return boardDtoList;
  }

  public Boards toEntity(BoardReadResponse boardReadResponse) {
    return Boards.builder()
      .id(boardReadResponse.getId())
      .contents(boardReadResponse.getContents())
      .title(boardReadResponse.getTitle())
      .deleteYn(boardReadResponse.getDeleteYn().charAt(0))
      .build();
  }
}
