package com.lms.restapidemo.member;

import com.lms.restapidemo.member.dto.memberLogin.MemberLoginRequest;
import com.lms.restapidemo.member.dto.memberLogin.MemberLoginResponse;
import com.lms.restapidemo.member.dto.memberSave.MemberSaveRequest;
import com.lms.restapidemo.member.dto.memberSave.MemberSaveResponse;
import com.lms.restapidemo.member.entity.Members;
import com.lms.restapidemo.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

  MemberService memberService;
  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  @PostMapping("/")
  public ResponseEntity createMember(@RequestBody MemberSaveRequest memberSaveRequest, Model model) throws Exception {

    MemberSaveResponse memberSaveResponse = memberService.createMember(memberSaveRequest);
    return new ResponseEntity(memberSaveResponse, HttpStatus.OK);
  }
  @GetMapping("/")
  public ResponseEntity getMemberList() {
    ResponseEntity re = new ResponseEntity(HttpStatus.OK);

    List<Members> members = memberService.findMembers();
    return new ResponseEntity(members,HttpStatus.OK);
  }

  @PostMapping("/login")
  public ResponseEntity login(@RequestBody MemberLoginRequest memberLoginRequest, Model model) throws Exception {

    MemberLoginResponse memberLoginResponse = memberService.findMembersByMemberNameAndPassword(memberLoginRequest);
    return new ResponseEntity(memberLoginResponse, HttpStatus.OK);
  }
}

