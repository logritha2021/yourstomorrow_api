package com.yourstomorrow.api.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "videos")
public class Video {
  @Id
  @Column(unique = true, nullable = false)
  private String id = UUID.randomUUID().toString().replace("-", "");
  private Integer videoIndex;
  private String subject;

  @NotNull(message = "videourl can not be empty")
  @JsonProperty("videoUrl")
  private String videoUrl;
  private String title;
}