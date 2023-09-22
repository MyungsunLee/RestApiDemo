package com.lms.restapidemo.member;

import com.lms.restapidemo.member.dto.memberLogin.MemberLoginRequest;
import com.lms.restapidemo.member.dto.memberLogin.MemberLoginResponse;
import com.lms.restapidemo.member.dto.memberRead.MemberReadRequest;
import com.lms.restapidemo.member.dto.memberRead.MemberReadResponse;
import com.lms.restapidemo.member.dto.memberSave.MemberSaveRequest;
import com.lms.restapidemo.member.dto.memberSave.MemberSaveResponse;
import com.lms.restapidemo.member.entity.Members;
import com.lms.restapidemo.member.service.MemberService;
import jakarta.annotation.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/members")
public class MemberController {

  MemberService memberService;
  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  @PostMapping("")
  public ResponseEntity createMember(@RequestBody MemberSaveRequest memberSaveRequest, Model model) throws Exception {

    MemberSaveResponse memberSaveResponse = memberService.createMember(memberSaveRequest);
    return new ResponseEntity(memberSaveResponse, HttpStatus.OK);
  }
  @GetMapping("")
  public ResponseEntity getMemberList(@RequestParam @Nullable Optional<String> searchCondition, String memberName, Integer memberId, @PageableDefault(size=10, page = 0, sort="createDate", direction = Sort.Direction.DESC) Pageable pageable) {


    ResponseEntity re = new ResponseEntity(HttpStatus.OK);

    MemberReadRequest memberReadRequest = new MemberReadRequest(memberId, memberName, searchCondition.orElse(""));
    Page<MemberReadResponse> memberReadResponses = memberService.memberReadListByFilter(memberReadRequest, pageable);
    return new ResponseEntity(memberReadResponses,HttpStatus.OK);
  }

  // public ResponseEntity getMemberListByCondition()

  @PostMapping("/login")
  public ResponseEntity login(@RequestBody MemberLoginRequest memberLoginRequest, Model model) throws Exception {

    MemberLoginResponse memberLoginResponse = memberService.findMembersByMemberNameAndPassword(memberLoginRequest);
    return new ResponseEntity(memberLoginResponse, HttpStatus.OK);
  }
}

