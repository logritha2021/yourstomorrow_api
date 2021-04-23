package com.yourstomorrow.api.repository;

import com.yourstomorrow.api.models.test_models.Test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestRepository extends JpaRepository<Test, String> {
}
