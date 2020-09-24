package com.globallogic.evaluacion.infrastructure.entity;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PHONE")
public class PhonesEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_phones", updatable = false, nullable = false)
  private Integer idPhones;

  @ApiModelProperty(notes = "number")
  @Column(name = "number")
  private String number;

  @ApiModelProperty(notes = "city code")
  @Column(name = "city_code")
  private String cityCode;

  @ApiModelProperty(notes = "contry code")
  @Column(name = "contry_code")
  private String contryCode;

  @ManyToOne(fetch = FetchType.LAZY)
  private UserEntity userEntity;

}
