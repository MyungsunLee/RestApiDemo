package com.lms.restapidemo.board.entity;

import java.util.Date;

import com.lms.restapidemo.board.boardRegistDto.BoardRegistResponse;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name="BOARDS")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Boards {

  @Id
  @Column(name = "ID", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "BOARD_ID_SEQ")
  private Integer id;

  @Column(name = "TITLE", nullable = false)
  private String title;

  @Column(name = "CONTENTS", nullable = false)
  private String contents;

  @Column(name = "IMAGES")
  private String images; // 우선 안씀, nullable

  @Column(name = "WRITER_ID", nullable = false)
  private Integer writerId;

  @Column(name = "REGIST_DATE")
  private Date registDate;

  @Column(name = "UPDATE_DATE")
  private Date updateDate;

  @Column(name = "DELETE_YN")
  private char deleteYn;

  @Column(name = "DELETE_DATE")
  private Date deleteDate;

  public Boards(String title, String contents, Integer writerId) {
    this.title = title;
    this.contents = contents;
    this.writerId = writerId;
  }

  public BoardRegistResponse toBoardRegistResponseDto(Boards boards) {
    return BoardRegistResponse.builder()
      .id(boards.getId())
      .title(boards.getTitle())
      .contents(boards.getContents())
      .registDate(boards.getRegistDate())
      .updateDate(boards.getUpdateDate())
      .build();

  }
}