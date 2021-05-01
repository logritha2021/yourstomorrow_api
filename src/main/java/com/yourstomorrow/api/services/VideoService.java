package com.yourstomorrow.api.services;

import java.util.List;

import com.yourstomorrow.api.exceptions.InvalidDataException;
import com.yourstomorrow.api.models.Video;
import com.yourstomorrow.api.repository.IVideoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

  final Integer defaultStartIndex = 1;
  final Integer defaultEndIndex = 3;
  final Integer videoOffset = 10;

  @Autowired
  IVideoRepository videoRepo;

  public List<Video> getAllVideos(Integer page) {
    if (page == null) {
      page = 1;
    }
    Pageable pagination = PageRequest.of(page, videoOffset);
    return videoRepo.findAll(pagination).toList();
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

  public List<Video> getVideoBySubjectName(String subjectName, Integer page) {
    if (subjectName == null || subjectName.length() == 0) {
      throw new InvalidDataException("subject name missing in path");
    }
    if (page == null) {
      page = 1;
    }
    Integer startindex = (videoOffset * (page - 1)) + 1;
    Integer endindex = startindex + videoOffset - 1;
    return videoRepo.findVideoBySubject(subjectName, startindex, endindex);
  }

  public List<String> getAllSubjectNames() {
    return videoRepo.getDistinctSubjectNames();
  }
}
