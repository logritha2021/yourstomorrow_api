package com.yourstomorrow.api.repository;

import java.util.Date;

import com.yourstomorrow.api.models.user_models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {
  @Query(value = "SELECT * from users where phone=?1", nativeQuery = true)
  User findUserByPhone(String phone);

  @Modifying
  @Query(value = "UPDATE users SET name = ?1,phone = ?2,email = ?3,dob=?4,updated_at=?5 where id = ?6", nativeQuery = true)
  @Transactional
  void updateUserById(String name, String phone, String email, Date dob, Date updatetime, String userId);
}
