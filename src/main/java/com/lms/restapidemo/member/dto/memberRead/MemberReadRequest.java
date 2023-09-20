package com.lms.restapidemo.member.dto.memberRead;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberReadRequest {
  private Integer memberId;
  private String memberName;
  private String searchCondition;
}
