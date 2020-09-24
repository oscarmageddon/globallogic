package com.globallogic.evaluacion.infrastructure.translator;

import com.globallogic.evaluacion.domain.request.PhonesRequest;
import com.globallogic.evaluacion.domain.request.UsuarioRequest;
import com.globallogic.evaluacion.domain.response.EvaluacionResponse;
import com.globallogic.evaluacion.infrastructure.entity.PhonesEntity;
import com.globallogic.evaluacion.infrastructure.entity.UserEntity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

@Component
public class EvaluacionTranslator {

  /**
   * Metodo .
   */
  public UserEntity translateRequestToEntity(UsuarioRequest usuarioRequest) {

    Optional<UsuarioRequest> opUsuarioRequest = Optional.ofNullable(usuarioRequest);

    if (!opUsuarioRequest.isPresent()) {
      return new UserEntity();
    }

    return UserEntity.builder()
        .name(Optional.ofNullable(usuarioRequest.getName()).orElse(Strings.EMPTY))
        .email(Optional.ofNullable(usuarioRequest.getEmail()).orElse(Strings.EMPTY))
        .password(Optional.ofNullable(usuarioRequest.getPassword()).orElse(Strings.EMPTY))
        .created(LocalDateTime.now())
        .modified(LocalDateTime.now())
        .lastLogin(LocalDateTime.now())
        .isActive(Boolean.TRUE)
        .phones(translateListPhones(usuarioRequest))
        .build();
  }

  private Set<PhonesEntity> translateListPhones(UsuarioRequest usuarioRequest) {
    Set<PhonesEntity> listPhonesEntity = new HashSet<>();

    usuarioRequest.getPhones().forEach(
        phonesRequest -> listPhonesEntity.add(translatePhones(phonesRequest))
    );

    return listPhonesEntity;
  }

  private PhonesEntity translatePhones(PhonesRequest phonesRequest) {
    return PhonesEntity.builder()
        .number(Optional.ofNullable(phonesRequest.getNumber()).orElse(Strings.EMPTY))
        .cityCode(Optional.ofNullable(phonesRequest.getCitycode()).orElse(Strings.EMPTY))
        .contryCode(Optional.ofNullable(phonesRequest.getContrycode()).orElse(Strings.EMPTY))
        .build();
  }

  /**
   * Metodo .
   */
  public EvaluacionResponse translateEntityToResponse(UserEntity userEntity, String token) {

    Optional<UserEntity> opUserEntity = Optional.ofNullable(userEntity);

    if (!opUserEntity.isPresent()) {
      return new EvaluacionResponse();
    }

    return EvaluacionResponse.builder()
        .id(userEntity.getIdUser())
        .created(userEntity.getCreated())
        .modified(userEntity.getModified())
        .lastLogin(userEntity.getLastLogin())
        .token(token)
        .isActive(userEntity.getIsActive())
        .build();
  }
}
