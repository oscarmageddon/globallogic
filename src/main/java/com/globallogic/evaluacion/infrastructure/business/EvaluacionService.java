package com.globallogic.evaluacion.infrastructure.business;

import com.globallogic.evaluacion.infrastructure.entity.UserEntity;
import com.globallogic.evaluacion.infrastructure.exception.EvaluacionException;
import com.globallogic.evaluacion.infrastructure.exception.ExceptionCause;
import com.globallogic.evaluacion.infrastructure.repository.PhonesRepository;
import com.globallogic.evaluacion.infrastructure.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EvaluacionService {

  private UserRepository userRepository;

  private PhonesRepository phonesRepository;

  @Autowired
  public EvaluacionService(UserRepository userRepository,
      PhonesRepository phonesRepository) {
    this.userRepository = userRepository;
    this.phonesRepository = phonesRepository;
  }

  /**
   * Metodo .
   *
   */
  public Boolean existsByEmail(String email) throws EvaluacionException {

    try {
      log.info("In existsByEmail");
      log.info("email -> " + email);

      Boolean isExists =
          userRepository.existsByEmail(email);

      log.info("isExists -> " + isExists);

      return isExists;

    } catch (Exception e) {
      throw new EvaluacionException(
          ExceptionCause.INTERNAL_SERVER_ERROR.toString(), "Error in exists by email.");
    }
  }

  /**
   * Metodo .
   *
   */
  public UserEntity save(UserEntity userEntity) throws EvaluacionException {

    try {
      log.info("In save");
      log.info("userEntity -> " + userEntity);

      UserEntity userEntityResponse =
          userRepository.save(userEntity);

      log.info("userEntityResponse -> " + userEntityResponse);

      return userEntityResponse;

    } catch (Exception e) {
      throw new EvaluacionException(
          ExceptionCause.INTERNAL_SERVER_ERROR.toString(), "Error in save.");
    }
  }
}
