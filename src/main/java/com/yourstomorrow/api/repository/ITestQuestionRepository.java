package com.yourstomorrow.api.repository;

import java.util.List;

import com.yourstomorrow.api.models.test_models.TestQuestion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestQuestionRepository extends JpaRepository<TestQuestion, String> {
  @Query(value = "SELECT tq.question_id FROM test_questions tq WHERE tq.test_id=?1", nativeQuery = true)
  List<String> findByQuestionId(String testid);
}
