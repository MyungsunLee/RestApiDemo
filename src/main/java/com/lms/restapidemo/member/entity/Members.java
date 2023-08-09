package com.lms.restapidemo.member.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.sql.Timestamp;
import java.time.*;

@Entity
@Getter
@Setter
@Table(name="MEMBERS")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Members {

  @Id
  @Column(name = "MEMBER_ID", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "MEMBER_ID_SEQ")
  private Integer memberId;

  @Column(name = "MEMBER_NAME")
  private String memberName;

  @Column(name = "PASSWORD", nullable = false)
  private String password;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "CREATE_DATE", nullable = false)
  private Timestamp createDate;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "UPDATE_DATE")
  private Date updateDate;

  @Column(name = "DELETE_YN", nullable = false)
  private char deleteYn;

  // get member list
  public Members(Integer memberId, String memberName, char deleteYn) {
    this.memberId = memberId;
    this.memberName = memberName;
    this.deleteYn = deleteYn;
  }
}
