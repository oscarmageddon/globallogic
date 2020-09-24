package com.globallogic.evaluacion.infrastructure.exception;

public enum ExceptionCause {
  INTERNAL_SERVER_ERROR("Internal Server Error"),
  BAD_REQUEST("Bad Request"),
  SERVICE_UNAVAILABLE("Service Unavailable"),
  NOT_FOUND("Not Found data"),
  CONFLICT("Conflict");

  private final String message;

  ExceptionCause(final String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
