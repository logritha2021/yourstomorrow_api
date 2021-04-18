package com.yourstomorrow.api.repository;

import com.yourstomorrow.api.models.Answer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IAnswerRespository extends JpaRepository<Answer, String> {

}
