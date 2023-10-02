package com.lms.restapidemo.member;

import com.lms.restapidemo.board.dto.update.BoardPutRequest;
import com.lms.restapidemo.common.ResponseEntityFactory;
import com.lms.restapidemo.common.exception.ApiException;
import com.lms.restapidemo.common.exception.ExceptionEnum;
import com.lms.restapidemo.member.dto.login.MemberLoginRequest;
import com.lms.restapidemo.member.dto.login.MemberLoginResponse;
import com.lms.restapidemo.member.dto.read.MemberReadRequest;
import com.lms.restapidemo.member.dto.read.MemberReadResponse;
import com.lms.restapidemo.member.dto.create.MemberSaveRequest;
import com.lms.restapidemo.member.dto.create.MemberSaveResponse;
import com.lms.restapidemo.member.service.MemberService;
import jakarta.annotation.Nullable;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/members")
public class MemberController {

  MemberService memberService;
  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  @PostMapping("")
  public ResponseEntity createMember(@RequestBody MemberSaveRequest memberSaveRequest) throws Exception {
    MemberSaveResponse memberSaveResponse = memberService.createMember(memberSaveRequest);
    return ResponseEntityFactory.make(memberSaveResponse);
  }
  @GetMapping("")
  public ResponseEntity getMemberList(@RequestParam @Nullable Optional<String> searchCondition, String memberName, Integer memberId, @PageableDefault(size=10, page = 0, sort="createDate", direction = Sort.Direction.DESC) Pageable pageable) {
    MemberReadRequest memberReadRequest = new MemberReadRequest(memberId, memberName, searchCondition.orElse(""));
    Page<MemberReadResponse> memberReadResponses = memberService.memberReadListByFilter(memberReadRequest, pageable);
    // TBD, 나중에 get으로 dto 받아오는 방법 모색
    return new ResponseEntity(memberReadResponses,HttpStatus.OK);
  }

  @PostMapping("/login")
  public ResponseEntity login(@RequestBody MemberLoginRequest memberLoginRequest, Model model) throws Exception {
    MemberLoginResponse memberLoginResponse = memberService.findMembersByMemberNameAndPassword(memberLoginRequest);
    return new ResponseEntity(memberLoginResponse, HttpStatus.OK);
  }

  @PostMapping("/delete")
  public ResponseEntity memberDelete(@RequestBody BoardPutRequest boardPutRequest) {
    return new ResponseEntity(HttpStatus.OK);
  }
}

