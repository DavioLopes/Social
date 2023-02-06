package com.example.social.social.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(nullable = false, length = 30, name = "name")
  private String name;

  @Column(nullable = false, length = 30, name = "username")
  private String userName;

  @Column(nullable = false, length = 10, name = "password")
  private String password;
  @Column(nullable = false, length = 20, name = "accountType")
  private String accountType;

  @Column(nullable = false, length = 12, name = "dataDeNascimento")
  private String dataDeNascimento;

  @CreatedDate
  @Column(nullable = false, name = "createdAt")
  private Instant createdDate;
  @OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
  private List<PostEntity> posts;

  @OneToMany(mappedBy = "comments", fetch = FetchType.LAZY)
  private List<CommentsEntity> comments;

  @OneToMany(mappedBy = "likes", fetch = FetchType.LAZY)
  private List<LikesEntity> likes;

}
