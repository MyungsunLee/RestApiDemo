package com.lms.restapidemo.board.entity;

import java.util.Date;

import com.lms.restapidemo.board.dto.read.BoardReadResponse;
import com.lms.restapidemo.board.dto.create.BoardRegistResponse;
import com.lms.restapidemo.common.BaseTimeEntity;
import com.lms.restapidemo.member.entity.Members;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name="BOARD")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Boards extends BaseTimeEntity {

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

//  @Column(name = "WRITER_ID", nullable = false)
//  private Integer writerId;

  @Column(name = "DELETE_YN")
  private char deleteYn;

  @Column(name = "DELETE_DATE")
  private Date deleteDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "WRITER_ID")
  private Members members;

  public Boards(String title, String contents) {
    this.title = title;
    this.contents = contents;
//    this.writerId = writerId;
  }

  public BoardRegistResponse toBoardRegistResponseDto(Boards boards) {
    return BoardRegistResponse.builder()
      .id(boards.getId())
      .title(boards.getTitle())
      .contents(boards.getContents())
      .createDate(boards.getCreateDate())
      .updateDate(boards.getUpdateDate())
      .build();
  }

  public BoardReadResponse toBoardReadResponeDto() {
    return BoardReadResponse.builder()
      .id(this.getId())
      .title(this.getTitle())
      .contents(this.getContents())
      .createDate(this.getCreateDate())
      .deleteYn(String.valueOf( this.getDeleteYn()))
      .writerName(this.getMembers().getMemberName())
      .build();
  }
  /*public BoardReadResponse toBoardReadResponseDto(Boards boards) {
    return BoardReadResponse.
  }*/
}
