package com.globallogic.evaluacion.infrastructure.provider;

import com.globallogic.evaluacion.domain.request.UsuarioRequest;
import com.globallogic.evaluacion.domain.response.EvaluacionResponse;
import com.globallogic.evaluacion.infrastructure.business.EvaluacionService;
import com.globallogic.evaluacion.infrastructure.entity.UserEntity;
import com.globallogic.evaluacion.infrastructure.exception.EvaluacionException;
import com.globallogic.evaluacion.infrastructure.exception.ExceptionCause;
import com.globallogic.evaluacion.infrastructure.helper.EvaluacionUtils;
import com.globallogic.evaluacion.infrastructure.translator.EvaluacionTranslator;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class EvaluacionProviderImpl implements EvaluacionProvider {

  private EvaluacionService evaluacionService;

  private EvaluacionTranslator evaluacionTranslator;

  @Autowired
  public EvaluacionProviderImpl(EvaluacionService evaluacionService,
      EvaluacionTranslator evaluacionTranslator) {
    this.evaluacionService = evaluacionService;
    this.evaluacionTranslator = evaluacionTranslator;
  }

  /**
   * Metodo .
   *
   */
  @Override
  public EvaluacionResponse save(UsuarioRequest usuarioRequest)
      throws EvaluacionException {

    Boolean existsByEmail = evaluacionService.existsByEmail(usuarioRequest.getEmail());

    if (existsByEmail.booleanValue()) {
      throw new EvaluacionException(
          ExceptionCause.CONFLICT.toString(), "Error ya existe el email.");
    }

    UserEntity userEntity = evaluacionTranslator.translateRequestToEntity(usuarioRequest);

    userEntity = evaluacionService.save(userEntity);

    String token = EvaluacionUtils.getJWTToken(userEntity.getEmail());

    return evaluacionTranslator.translateEntityToResponse(userEntity, token);
  }
}
