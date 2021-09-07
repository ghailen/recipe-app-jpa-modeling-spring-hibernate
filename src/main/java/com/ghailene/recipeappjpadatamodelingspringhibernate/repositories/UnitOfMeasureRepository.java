package com.ghailene.recipeappjpadatamodelingspringhibernate.repositories;

import com.ghailene.recipeappjpadatamodelingspringhibernate.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByDescription(String description);
}
