package com.lms.restapidemo.member.service;

import com.lms.restapidemo.member.dto.memberLogin.MemberLoginRequest;
import com.lms.restapidemo.member.dto.memberLogin.MemberLoginResponse;
import com.lms.restapidemo.member.dto.memberRead.MemberReadRequest;
import com.lms.restapidemo.member.dto.memberRead.MemberReadResponse;
import com.lms.restapidemo.member.dto.memberSave.MemberSaveRequest;
import com.lms.restapidemo.member.dto.memberSave.MemberSaveResponse;
import com.lms.restapidemo.member.entity.Members;
import com.lms.restapidemo.member.respsitory.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.lms.restapidemo.common.EncryptPassword;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
  private final MemberRepository memberRepository;

  public MemberSaveResponse createMember(MemberSaveRequest memberSaveRequest) throws Exception {
    Members member = memberSaveRequest.toEntity();
    member.setPassword(EncryptPassword.encrypt(member.getPassword()));
    Members result = memberRepository.save(member);
    return result.toMemberSaveResponseDto(result);
  }

  public List<MemberReadResponse> findAll() {
    List<Members> members = memberRepository.findAll();

    List<MemberReadResponse> memberReadResponses = members.stream().map(e -> e.toMemberReadResponse(e)).toList();
    return memberReadResponses;
  }
  public Page<MemberReadResponse> memberReadListByFilter(MemberReadRequest memberReadRequest, Pageable pageable) {

    Page<Members> members = null;
    if(memberReadRequest.getSearchCondition().equals("memberName")) {
      members = memberRepository.findByMemberNameContains(memberReadRequest.getMemberName(), pageable);
    }else if(memberReadRequest.getSearchCondition().equals("memberId")){
      members = memberRepository.findByMemberId(memberReadRequest.getMemberId(), pageable);
    }else {
      members = memberRepository.findAll(pageable);
    }

    Page<MemberReadResponse> memberReadResponses = new MemberReadResponse().toMemberReadDtoList(members);
    return memberReadResponses;
  }

  public MemberLoginResponse findMembersByMemberNameAndPassword(MemberLoginRequest memberLoginRequest) throws Exception{
    memberLoginRequest.setPassword(EncryptPassword.encrypt(memberLoginRequest.getPassword()));
    List<Members> member = memberRepository.findByMemberNameAndPassword(memberLoginRequest.getMemberName(), memberLoginRequest.getPassword());

    if(member.size() > 0) {
      return MemberLoginResponse.builder()
        .members(member.get(0))
        .build();
    }else {
      return null;
    }
  }
}