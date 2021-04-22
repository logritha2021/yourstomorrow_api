package com.yourstomorrow.api.services;

import java.util.List;

import com.yourstomorrow.api.exceptions.InvalidDataException;
import com.yourstomorrow.api.models.Video;
import com.yourstomorrow.api.repository.IVideoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

  final Integer defaultStartIndex = 1;
  final Integer defaultEndIndex = 3;

  @Autowired
  IVideoRepository videoRepo;

  public List<Video> getAllVideos() {
    return videoRepo.findVideos(defaultStartIndex, defaultEndIndex);
  }

  public Video addNewVideo(Video v) {
    if (v.getSubject() == null) {
      throw new InvalidDataException("subject name can not be null");
    }
    Integer presentCount = videoRepo.getVideoCountOfASubject(v.getSubject());
    v.setVideoIndex(presentCount + 1);
    Video savedvideo = videoRepo.save(v);
    return savedvideo;
  }

  public List<Video> getVideoBySubjectName(String subjectName) {
    if (subjectName == null || subjectName.length() == 0) {
      throw new InvalidDataException("subject name missing in path");
    }
    return videoRepo.findVideoBySubject(subjectName);
  }
}
