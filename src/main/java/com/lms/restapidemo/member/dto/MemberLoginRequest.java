package com.lms.restapidemo.member.dto;

import com.lms.restapidemo.common.EncryptPassword;
import com.lms.restapidemo.member.entity.Members;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberLoginRequest {

  @NotBlank
  private String memberName;

  @NotBlank
  private String password;

  @Builder
  public MemberLoginRequest(String memberName, String password) {
    this.memberName = memberName;
    this.password = password;
  }

  public Members toEntity() throws Exception {
    return Members.builder()
      .memberName(memberName)
      .password(EncryptPassword.encrypt(password))
      .build();
  }
}
