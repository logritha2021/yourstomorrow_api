package com.yourstomorrow.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
public class Video {
  @Id
  @Column(unique = true, nullable = false)
  private String id;
  private Integer index;
  private String subject;
  private String videoUrl;
  private String title;
}