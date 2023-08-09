package com.lms.restapidemo.member.service;

import com.lms.restapidemo.member.entity.Members;
import com.lms.restapidemo.member.respsitory.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.lms.restapidemo.common.EncryptPassword;

import java.time.LocalDateTime;
import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
  private final MemberRepository memberRepository;

  public Members createMember(Members member) throws Exception {
    member.setPassword(EncryptPassword.encrypt(member.getPassword()));
    member.setCreateDate(new Timestamp(System.currentTimeMillis()));
    member.setUpdateDate(new Timestamp(System.currentTimeMillis()));
    Members result = memberRepository.save(member);
    return result;
  }

  public List<Members> findMembers() {
    List<Members> members = memberRepository.findAll();
    return members;
  }

}
