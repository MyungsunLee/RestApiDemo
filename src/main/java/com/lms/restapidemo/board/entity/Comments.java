package com.lms.restapidemo.board.entity;

import com.lms.restapidemo.common.BaseTimeEntity;
import com.lms.restapidemo.member.entity.Members;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name="COMMENT")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comments extends BaseTimeEntity {
  @Id
  @Column(name = "ID", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "COMMENT_ID_SEQ")
  private Integer id;

  @Column(name = "PARENT_ID")
  private Integer parentId;

  @Column(name = "LEVEL")
  private Integer level;

  @Column(name = "contents")
  private String contents;

  @Column(name = "DELETE_YN")
  @Builder.Default
  private Character deleteYn = 'N';

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "BOARD_ID")
  private Boards boards;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "USER_ID")
  private Members members;

  public Comments(Integer id, Integer boardId, Integer parentId,
                  Integer level, String contents) {
    this.id = id;
    // this.boards.setId(boardId);
    this.parentId = parentId;
    this.level = level;
    this.contents = contents;
  }
}
