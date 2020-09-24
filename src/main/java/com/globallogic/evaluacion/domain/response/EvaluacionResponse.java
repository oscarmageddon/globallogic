package com.globallogic.evaluacion.domain.response;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Evaluacion Response")
public class EvaluacionResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  private LocalDateTime created;
  private LocalDateTime modified;
  private LocalDateTime lastLogin;
  private String token;
  private Boolean isActive;
}