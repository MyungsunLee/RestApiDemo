package com.lms.restapidemo.member.entity;

import com.lms.restapidemo.board.entity.Boards;
import com.lms.restapidemo.common.BaseTimeEntity;
import com.lms.restapidemo.member.dto.memberSave.MemberSaveResponse;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.sql.Timestamp;
import java.time.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="MEMBERS")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Members extends BaseTimeEntity {

  @Id
  @Column(name = "MEMBER_ID", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "MEMBER_ID_SEQ")
  private Integer memberId;

  @Column(name = "MEMBER_NAME")
  private String memberName;

  @Column(name = "PASSWORD", nullable = false)
  private String password;

  @Column(name = "DELETE_YN")
  private char deleteYn;

  // @OneToMany(mappedBy = "members")
//  @JoinTable(name = "BOARDS", joinColumns = @JoinColumn(name = "MEMBER_ID"))
   // private List<Boards> boards;

  public Members(Integer memberId, String memberName, char deleteYn) {
    this.memberId = memberId;
    this.memberName = memberName;
    this.deleteYn = deleteYn;
  }
  public MemberSaveResponse toMemberSaveResponseDto(Members member) {
    return MemberSaveResponse.builder()
      .memberName(member.getMemberName())
      .memberId(member.getMemberId())
      .build();
  }
}
