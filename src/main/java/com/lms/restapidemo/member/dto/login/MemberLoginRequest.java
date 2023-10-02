package com.lms.restapidemo.member.dto.login;

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

  @NotBlank(message = "아이디를 입력해 주세요")
  private String memberName;

  @NotBlank(message = "비밀번호를 입력해 주세요")
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
