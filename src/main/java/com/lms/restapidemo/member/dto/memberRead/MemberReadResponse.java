package com.lms.restapidemo.member.dto.memberRead;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberReadResponse {
  Integer memberId;
  String memberName;
  LocalDateTime createDate;
  LocalDateTime updateDate;
}
