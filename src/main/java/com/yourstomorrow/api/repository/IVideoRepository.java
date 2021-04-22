package com.yourstomorrow.api.repository;

import java.util.List;

import com.yourstomorrow.api.models.Video;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IVideoRepository extends JpaRepository<Video, String> {
  @Query("FROM Video v WHERE v.subject=?1")
  List<Video> findVideoBySubject(String subjectName);

  @Query("FROM Video v WHERE v.videoIndex BETWEEN ?1 AND ?2")
  List<Video> findVideos(Integer startIndex, Integer endIndex);

  @Query("SELECT COUNT(v) FROM Video v where v.subject=?1")
  Integer getVideoCountOfASubject(String subjectName);
}
