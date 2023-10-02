package com.lms.restapidemo.member.dto.create;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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