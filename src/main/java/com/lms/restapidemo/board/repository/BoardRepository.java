package com.lms.restapidemo.board.repository;

import com.lms.restapidemo.board.entity.Boards;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

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
  List<Boards> findByDeleteYn(char deleteYn, Pageable pageable);

  /**
   * Find by title contains list.
   *
   * @param title    the title
   * @param pageable the pageable
   * @return the list
   */
  Page<Boards> findByTitleContainsAndDeleteYn(String title, Pageable pageable, char deleteYn);

  /**
   * Find by contents contains list.
   *
   * @param contents the contents
   * @param pageable the pageable
   * @return the list
   */
  public Page<Boards> findByContentsContainsAndDeleteYn(String contents, Pageable pageable, char deleteYn);

  Page<Boards> findById(Integer id, Pageable pageable);

  Optional<Boards> findByIdAndDeleteYn(Integer id, char deleteYn);

  void deleteById(Integer id);

}