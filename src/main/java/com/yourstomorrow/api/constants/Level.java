package com.yourstomorrow.api.constants;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Level {
  @JsonProperty("easy")
  EASY, @JsonProperty("medium")
  MEDIUM, @JsonProperty("hard")
  HARD;
}
