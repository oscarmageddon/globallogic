package com.globallogic.evaluacion.infrastructure.provider;

import com.globallogic.evaluacion.domain.request.UsuarioRequest;
import com.globallogic.evaluacion.domain.response.EvaluacionResponse;
import com.globallogic.evaluacion.infrastructure.exception.EvaluacionException;

public interface EvaluacionProvider {

  EvaluacionResponse save(UsuarioRequest usuarioRequest)
      throws EvaluacionException;
}
