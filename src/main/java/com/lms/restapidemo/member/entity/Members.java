package com.lms.restapidemo.member.entity;

import com.lms.restapidemo.common.BaseTimeEntity;
import com.lms.restapidemo.member.dto.memberRead.MemberReadResponse;
import com.lms.restapidemo.member.dto.memberSave.MemberSaveResponse;
import jakarta.persistence.*;
import lombok.*;

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
  @Builder.Default
  private Character deleteYn = 'N';

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
  public MemberReadResponse toMemberReadResponse(Members member) {
    return MemberReadResponse.builder()
      .memberId(member.getMemberId())
      .memberName(member.getMemberName())
      .createDate(member.getCreateDate())
      .updateDate(member.getUpdatedDate())
      .build();
  }
}
