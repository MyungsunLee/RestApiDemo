package com.lms.restapidemo.board.repository;

import com.lms.restapidemo.board.entity.Boards;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The interface Board repository.
 */
public interface BoardRepository extends JpaRepository<Boards, Integer> {
  /**
   * Find by delete yn list.
   *
   * @param deleteYn the delete yn
   * @param pageable the pageable
   * @return the list
   */
  public List<Boards> findByDeleteYn(char deleteYn, Pageable pageable);

  /**
   * Find by title contains list.
   *
   * @param title    the title
   * @param pageable the pageable
   * @return the list
   */
  public Page<Boards> findByTitleContains(String title, Pageable pageable);

  /**
   * Find by contents contains list.
   *
   * @param contents the contents
   * @param pageable the pageable
   * @return the list
   */
  public Page<Boards> findByContentsContains(String contents, Pageable pageable);

  Page<Boards> findById(Integer id, Pageable pageable);
}