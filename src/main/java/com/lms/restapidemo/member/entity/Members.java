package com.lms.restapidemo.member.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="MEMBERS")
public class Members {
  @Id
  @Column(name = "member_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_ID_SEQ")
  private Integer memberId;

  @Column(name = "member_name")
  private String memberName;

  @Column(name = "password", nullable = false)
  private String password;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "create_date", nullable = false)
  private Date createDate;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "update_date")
  private Date updateDate;

  @Column(name = "delete_yn", nullable = false)
  private char deleteYn;

}
