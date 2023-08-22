package com.lms.restapidemo.member.dto.memberSave;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class MemberSaveResponse {

  private Integer memberId;
  private String memberName;

  @Builder
  public MemberSaveResponse(Integer memberId, String memberName) {
    this.memberId = memberId;
    this.memberName = memberName;
  }
}
