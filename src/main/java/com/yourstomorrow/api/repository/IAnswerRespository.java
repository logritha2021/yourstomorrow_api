package com.yourstomorrow.api.repository;

import com.yourstomorrow.api.models.Answer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnswerRespository extends JpaRepository<Answer, String> {

}
