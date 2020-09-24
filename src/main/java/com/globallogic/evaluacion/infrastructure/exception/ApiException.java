package com.globallogic.evaluacion.infrastructure.exception;

public class ApiException extends Exception {

  private static final long serialVersionUID = 1L;
  private final int status;

  public ApiException(String message, int status) {
    super(message);
    this.status = status;
  }

  public int getErrorStatus() {
    return this.status;
  }
}
