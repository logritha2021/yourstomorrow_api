package com.yourstomorrow.api.repository;

import com.yourstomorrow.api.models.UserTestStats;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserTestStatRepostory extends JpaRepository<UserTestStats, String> {
  @Query(value = "SELECT * FROM user_test_stats WHERE test_id=?1 AND user_id=?2", nativeQuery = true)
  UserTestStats findStatByUserAndTestId(String testId, String userId);
}
