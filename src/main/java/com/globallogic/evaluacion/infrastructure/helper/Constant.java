package com.globallogic.evaluacion.infrastructure.helper;

public class Constant {

  public static final String HEADER = "header";
  public static final String HEADER_TRACK_ID = "X-Track-Id";
  public static final String HEADER_APP_NAME = "X-Application-Name";
  public static final String EXAMPLE_ID = "120e9c3f-2202-4430-b1fa-4be92d5ecdc4";
  public static final String APP_NAME = "your-app-name";
  public static final String OK = "Ok";

  public static final String BAD_REQUEST = "Bad Request";
  public static final String NOT_FOUND = "Not Found";
  public static final String INTERNAL_SERVER_ERROR = "Internal Server Error";
  public static final String SERVICE_UNAVAILABLE = "Service Unavailable";
  public static final String TRACK_ID_VALUE =
      "Unique identifier that links the entire tracking associated with a customer";
  public static final String APP_VALUE = "The application name that will be consuming this service";

  private Constant() {
    // no use
  }
}
