package com.lms.restapidemo.board.repository;

import com.lms.restapidemo.board.entity.Boards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Boards, Integer> {
  public List<Boards> findByDeleteYn(Boards boards);
}
