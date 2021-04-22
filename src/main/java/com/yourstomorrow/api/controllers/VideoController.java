package com.yourstomorrow.api.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import com.yourstomorrow.api.models.Video;
import com.yourstomorrow.api.services.VideoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/video")
public class VideoController {
  @Autowired
  VideoService service;

  @GetMapping("")
  public ResponseEntity<List<Video>> getVideos() {
    List<Video> allVids = service.getAllVideos();
    if (allVids.size() == 0) {
      return new ResponseEntity<>(allVids, HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(allVids, HttpStatus.OK);
  }

  @PostMapping("")
  public ResponseEntity<Video> addNewVideo(@Valid @RequestBody Video video) {
    Video newVdVideo = service.addNewVideo(video);
    return new ResponseEntity<>(newVdVideo, HttpStatus.CREATED);
  }

  @GetMapping("/subject/{name}")
  public ResponseEntity<List<Video>> bySubjectName(@PathVariable String name) {
    List<Video> allVideos = service.getVideoBySubjectName(name);
    if (allVideos.size() == 0) {
      return new ResponseEntity<>(allVideos, HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(allVideos, HttpStatus.OK);
  }
}
