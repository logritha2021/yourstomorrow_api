package com.yourstomorrow.api.repository;

import java.util.List;

import com.yourstomorrow.api.models.Video;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IVideoRepository extends JpaRepository<Video, String> {
  @Query("SELECT v FROM video v WHERE subject=?1")
  List<Video> findVideoBySubject(String subjectName);

  @Query("SELECT v FROM video v WHERE index BETWEEN 1 AND 3")
  List<Video> findVideos();
}
