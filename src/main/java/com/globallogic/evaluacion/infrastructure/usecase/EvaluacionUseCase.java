package com.globallogic.evaluacion.infrastructure.usecase;

import com.globallogic.evaluacion.domain.request.UsuarioRequest;
import com.globallogic.evaluacion.domain.response.EvaluacionResponse;
import com.globallogic.evaluacion.infrastructure.exception.EvaluacionException;
import com.globallogic.evaluacion.infrastructure.provider.EvaluacionProvider;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EvaluacionUseCase {

  private EvaluacionProvider evaluacionProvider;

  @Autowired
  public EvaluacionUseCase(EvaluacionProvider evaluacionProvider) {
    this.evaluacionProvider = evaluacionProvider;
  }

  /**
   * Metodo.
   *
   */
  public EvaluacionResponse save(UsuarioRequest usuarioRequest)
      throws EvaluacionException {

    return evaluacionProvider.save(usuarioRequest);
  }
}
