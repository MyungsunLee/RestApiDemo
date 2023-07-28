package com.lms.restapidemo.member;


import com.lms.restapidemo.member.entity.Members;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

  @PostMapping("/member")
  public ResponseEntity createMemer(Members members, Model model) {
    return new ResponseEntity(HttpStatus.OK);
  }
}
