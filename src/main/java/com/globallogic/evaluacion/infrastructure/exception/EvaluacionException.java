package com.globallogic.evaluacion.infrastructure.exception;

public class EvaluacionException extends Exception {

  static final long serialVersionUID = 1L;

  private final String detailMessage;

  public EvaluacionException(String message, String detailMessage) {
    super(message);
    this.detailMessage = detailMessage;
  }

  public String getDetailMessage() {
    return detailMessage;
  }
}
