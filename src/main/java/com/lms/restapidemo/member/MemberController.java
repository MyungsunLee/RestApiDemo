package com.lms.restapidemo.member;

import com.lms.restapidemo.member.entity.Members;
import com.lms.restapidemo.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {

  MemberService memberService;
  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  @PostMapping("/member")
  public ResponseEntity createMemer(@RequestBody Members members, Model model) throws Exception {

    memberService.createMember(members);
    return new ResponseEntity(HttpStatus.OK);
  }
  @GetMapping("/member")
  public ResponseEntity getMemberList() {
    ResponseEntity re = new ResponseEntity(HttpStatus.OK);

    List<Members> members = memberService.findMembers();
    return new ResponseEntity(members,HttpStatus.OK);
  }

}

