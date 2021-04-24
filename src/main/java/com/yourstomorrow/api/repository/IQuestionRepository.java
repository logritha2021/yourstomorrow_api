package com.yourstomorrow.api.repository;

import java.util.List;

import com.yourstomorrow.api.models.Question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionRepository extends JpaRepository<Question, String> {
  @Query(value = "SELECT * from questions where subject=?1", nativeQuery = true)
  List<Question> findQuestionsBySubjectName(String subjectName);
}
