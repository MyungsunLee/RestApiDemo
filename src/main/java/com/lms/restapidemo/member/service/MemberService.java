package com.lms.restapidemo.member.service;

import com.lms.restapidemo.member.entity.Members;
import com.lms.restapidemo.member.respsitory.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
  private final MemberRepository memberRepository;

  public Members createMember(Members member) {
    Members result = memberRepository.save(member);
    return result;
  }


}
