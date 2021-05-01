package com.yourstomorrow.api.repository;

import com.yourstomorrow.api.models.test_models.TestStats;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestStatRepository extends JpaRepository<TestStats, String> {

}
