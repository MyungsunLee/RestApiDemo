package com.lms.restapidemo.member.dto.login;

import com.lms.restapidemo.member.entity.Members;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberLoginResponse {

  @NotNull
  private Integer memberId;

  @NotBlank
  private String memberName;

  @Builder
  public MemberLoginResponse(Members members) {
    this.memberId = members.getMemberId();
    this.memberName = members.getMemberName();
  }

}
