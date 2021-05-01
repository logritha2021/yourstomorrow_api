package com.yourstomorrow.api.controllers;

import java.util.ArrayList;
import java.util.List;

import com.yourstomorrow.api.models.test_models.TestStats;
import com.yourstomorrow.api.models.wrappers.Response;
import com.yourstomorrow.api.models.wrappers.UserId;
import com.yourstomorrow.api.services.StatsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatController {

  @Autowired
  StatsService statsService;

  @PostMapping("/test/create/{testId}")
  public Response<TestStats> createtTestStats(@PathVariable String testId) {
    TestStats newstats = statsService.createStatForATest(testId);
    return new Response<>(newstats);
  }

  @GetMapping("/test/{testId}")
  public Response<TestStats> getStatisticsOfATest(@PathVariable String testId) {
    TestStats newstats = statsService.findATestStat(testId);
    return new Response<>(newstats);
  }

  @PostMapping("/user")
  public Response<List<TestStats>> allStatisticsOfAnUser(@RequestBody UserId body) {
    List<TestStats> allstats = new ArrayList<>();
    return new Response<>(allstats);
  }

  // @PostMapping("/user/overview")
  // public Response<List<TestStats>> StatisticsOverviewOfAnUser(@PathVariable
  // String userId) {
  // List<TestStats> allstats = new ArrayList<>();
  // return new Response<>(allstats);
  // }

}
