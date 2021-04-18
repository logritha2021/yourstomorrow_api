package com.yourstomorrow.api.repository;

import com.yourstomorrow.api.models.Question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionRepository extends JpaRepository<Question, String> {
}
