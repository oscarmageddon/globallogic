package com.globallogic.evaluacion.infrastructure.repository;

import com.globallogic.evaluacion.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
    extends JpaRepository<UserEntity, Integer> {

  Boolean existsByEmail(String email);
}
