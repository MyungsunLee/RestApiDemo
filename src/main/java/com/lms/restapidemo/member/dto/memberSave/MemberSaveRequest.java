package com.lms.restapidemo.member.dto.memberSave;

import com.lms.restapidemo.member.entity.Members;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class MemberSaveRequest {

  private String memberName;
  private String password;
  private Timestamp createDate;
  private Timestamp updateDate;


  @Builder
  public MemberSaveRequest(String memberName, String password) {
    this.memberName = memberName;
    this.password = password;
  }

  public Members toEntity() {
    return Members.builder()
      .memberName(memberName)
      .password(password)
      .build();
  }

}
