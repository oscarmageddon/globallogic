package com.globallogic.evaluacion.controller;

import com.globallogic.evaluacion.infrastructure.exception.EvaluacionException;
import com.globallogic.evaluacion.infrastructure.exception.ExceptionMessage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WebRestControllerAdvice {

  /**
   * Method that allow response a custom error.
   *
   */
  @ExceptionHandler(value = {EvaluacionException.class})
  public ResponseEntity<ExceptionMessage> sessionInternalError(
      EvaluacionException exception) {

    return new ResponseEntity<>(
        ExceptionMessage.builder()
            .message(exception.getDetailMessage())
            .build(),
        HttpStatus.CONFLICT);
  }

  /**
   * Method who let handle the Validations Errors.
   *
   */
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    BindingResult bindingResult = ex.getBindingResult();
    List<ObjectError> allErrors = bindingResult.getAllErrors();

    allErrors.forEach(
        error -> {
          FieldError fieldError = (FieldError) error;
          String fieldName = fieldError.getField();
          String errorMessage = error.getDefaultMessage();
          errors.put(fieldName, errorMessage);
        });

    return errors;
  }
}
