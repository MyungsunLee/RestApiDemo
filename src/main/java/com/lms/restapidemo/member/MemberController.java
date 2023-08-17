package com.lms.restapidemo.member;

import com.lms.restapidemo.member.dto.MemberLoginRequest;
import com.lms.restapidemo.member.dto.MemberLoginResponse;
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
  public ResponseEntity createMemer(@RequestBody Members members, Model model) throws Exception {

    memberService.createMember(members);
    return new ResponseEntity(HttpStatus.OK);
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

