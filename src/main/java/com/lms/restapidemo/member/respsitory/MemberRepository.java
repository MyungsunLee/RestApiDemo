package com.lms.restapidemo.member.respsitory;

import com.lms.restapidemo.member.entity.Members;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * The interface Member repository.
 */
@Repository
public interface MemberRepository extends JpaRepository<Members, Integer> {

  /**
   * Find members list by member name and password.
   *
   * @param memberName the member name
   * @param password   the password
   * @return the list
   */
  List<Members> findByMemberNameAndPassword(String memberName, String password);

  /**
   * Find members list by id.
   *
   * @param memberId the member id
   * @param pageable the pageable
   * @return the list
   */
  Page<Members> findByMemberId(Integer memberId, Pageable pageable);

  /**
   * Find members list by name.
   *
   * @param memberName the member name
   * @param pageable   the pageable
   * @return the list
   */
  Page<Members> findByMemberNameContains(String memberName, Pageable pageable);

  Page<Members> findAll(Pageable pageable);

}
