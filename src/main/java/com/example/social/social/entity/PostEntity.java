package com.example.social.social.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "Post")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostEntity implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false, length = 280)
  private String text;

  @CreatedDate
  private Instant createdDate;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserEntity users;
}
