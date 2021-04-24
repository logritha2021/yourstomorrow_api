package com.yourstomorrow.api.repository;

import java.util.Date;

// import javax.transaction.Transactional;

import com.yourstomorrow.api.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {
  @Modifying
  @Query(value = "UPDATE users SET name = ?1,phone = ?2,email = ?3,dob=?4,updated_at=?5 where id = ?6", nativeQuery = true)
  @Transactional
  void updateUserById(String name, String phone, String email, Date dob, Date updatetime, String userId);
}