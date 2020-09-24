package com.globallogic.evaluacion.infrastructure.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionMessage {

  private String timestamp;
  private String status;
  private String error;
  private String message;
  private String path;
  private String type;
  private String errorCode;
}
