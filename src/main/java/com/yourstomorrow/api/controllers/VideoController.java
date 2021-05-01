package com.yourstomorrow.api.controllers;

import java.util.List;

import javax.validation.Valid;

import com.yourstomorrow.api.models.Video;
import com.yourstomorrow.api.models.wrappers.Response;
import com.yourstomorrow.api.services.VideoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/video")
public class VideoController {
  @Autowired
  VideoService service;

  @GetMapping("")
  public Response<List<Video>> getVideos(@RequestParam(required = false) Integer page) {
    List<Video> allVids = service.getAllVideos(page);
    return new Response<>(allVids);
  }

  @PostMapping("")
  public Response<Video> addNewVideo(@Valid @RequestBody Video video) {
    Video newVdVideo = service.addNewVideo(video);
    return new Response<>(newVdVideo);
  }

  @GetMapping("/subject/{name}")
  public Response<List<Video>> bySubjectName(@PathVariable String name, @RequestParam(required = false) Integer page) {
    List<Video> allVideos = service.getVideoBySubjectName(name, page);
    return new Response<>(allVideos);
  }

  @GetMapping("/subject/names")
  public Response<List<String>> allSubjectNames() {
    List<String> allnames = service.getAllSubjectNames();
    return new Response<>(allnames);
  }
}
