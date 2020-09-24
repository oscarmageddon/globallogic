package com.globallogic.evaluacion.infrastructure.repository;

import com.globallogic.evaluacion.infrastructure.entity.PhonesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhonesRepository
    extends JpaRepository<PhonesEntity, Integer> {

}
