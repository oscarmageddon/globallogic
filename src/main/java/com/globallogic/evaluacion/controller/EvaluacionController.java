package com.globallogic.evaluacion.controller;

import com.globallogic.evaluacion.domain.request.UsuarioRequest;
import com.globallogic.evaluacion.domain.response.EvaluacionResponse;
import com.globallogic.evaluacion.infrastructure.exception.EvaluacionException;
import com.globallogic.evaluacion.infrastructure.helper.Constant;
import com.globallogic.evaluacion.infrastructure.usecase.EvaluacionUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.sql.SQLException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api
@RestController
public class EvaluacionController {

  private EvaluacionUseCase evaluacionUseCase;

  @Autowired
  public EvaluacionController(EvaluacionUseCase evaluacionUseCase) {
    this.evaluacionUseCase = evaluacionUseCase;
  }

  /**
   * Metodo .
   *
   */
  @ApiOperation(
      value = "Metodo",
      response = EvaluacionResponse.class,
      responseContainer = "EvaluacionResponse")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = Constant.OK),
        @ApiResponse(code = 400, message = Constant.BAD_REQUEST),
        @ApiResponse(code = 404, message = Constant.NOT_FOUND),
        @ApiResponse(code = 500, message = Constant.INTERNAL_SERVER_ERROR),
        @ApiResponse(code = 503, message = Constant.SERVICE_UNAVAILABLE)
      })
  @ApiImplicitParams({
      @ApiImplicitParam(
        name = Constant.HEADER_TRACK_ID,
        value = Constant.TRACK_ID_VALUE,
        required = false,
        allowEmptyValue = true,
        paramType = Constant.HEADER,
        dataTypeClass = String.class,
        example = Constant.EXAMPLE_ID),
      @ApiImplicitParam(
        name = Constant.HEADER_APP_NAME,
        value = Constant.APP_VALUE,
        required = false,
        allowEmptyValue = true,
        paramType = Constant.HEADER,
        dataTypeClass = String.class,
        example = Constant.APP_NAME)
  })
  @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<EvaluacionResponse> save(
      @RequestBody UsuarioRequest usuarioRequest)
      throws EvaluacionException {

    log.info("save");
    log.info(usuarioRequest.toString());

    EvaluacionResponse evaluacionResponse = evaluacionUseCase.save(usuarioRequest);

    log.info("response");
    log.info(evaluacionResponse.toString());

    return new ResponseEntity<>(evaluacionResponse, HttpStatus.CREATED);
  }
}
