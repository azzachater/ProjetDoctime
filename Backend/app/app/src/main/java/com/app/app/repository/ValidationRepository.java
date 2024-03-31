package com.app.app.repository;

import com.app.app.entities.Validation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface ValidationRepository extends CrudRepository<Validation, Integer> {

    Optional<Validation> findByCode(String code);
}