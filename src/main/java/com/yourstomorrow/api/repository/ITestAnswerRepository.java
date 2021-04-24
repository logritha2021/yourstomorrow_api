package com.yourstomorrow.api.repository;

import com.yourstomorrow.api.models.test_models.TestAnswer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ITestAnswerRepository extends JpaRepository<TestAnswer, String> {

}
