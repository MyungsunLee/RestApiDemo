package com.lms.restapidemo.member.respsitory;

import com.lms.restapidemo.member.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Members, Integer> {

  Members findMembersByMemberId(Integer memberId);

}
