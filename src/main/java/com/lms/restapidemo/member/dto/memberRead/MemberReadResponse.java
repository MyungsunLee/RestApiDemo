package com.lms.restapidemo.member.dto.memberRead;

import com.lms.restapidemo.board.boardReadDto.BoardReadResponse;
import com.lms.restapidemo.board.entity.Boards;
import com.lms.restapidemo.member.entity.Members;
import lombok.*;
import org.springframework.data.domain.Page;

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

  public Page<MemberReadResponse> toMemberReadDtoList(Page<Members> memberList){
    Page<MemberReadResponse> memberReadResponses = memberList.map(m -> MemberReadResponse.builder()
      .memberId(m.getMemberId())
      .memberName(m.getMemberName())
      .createDate(m.getCreateDate())
      .updateDate(m.getUpdateDate())
      .build());
    return memberReadResponses;
  }
}
