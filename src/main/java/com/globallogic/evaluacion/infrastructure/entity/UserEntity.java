package com.globallogic.evaluacion.infrastructure.entity;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER")
public class UserEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_user", updatable = false, nullable = false)
  private Integer idUser;

  @ApiModelProperty(notes = "name")
  @Column(name = "name")
  private String name;

  @ApiModelProperty(notes = "email")
  @Column(name = "email")
  private String email;

  @ApiModelProperty(notes = "password")
  @Column(name = "password")
  private String password;

  @ApiModelProperty(notes = "created")
  @Column(name = "created")
  private LocalDateTime created;

  @ApiModelProperty(notes = "modified")
  @Column(name = "modified")
  private LocalDateTime modified;

  @ApiModelProperty(notes = "last login")
  @Column(name = "last_login")
  private LocalDateTime lastLogin;

  @ApiModelProperty(notes = "is active")
  @Column(name = "is_active")
  private Boolean isActive;

  @OneToMany(
      mappedBy = "userEntity",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private Set<PhonesEntity> phones = new HashSet<>();
}
