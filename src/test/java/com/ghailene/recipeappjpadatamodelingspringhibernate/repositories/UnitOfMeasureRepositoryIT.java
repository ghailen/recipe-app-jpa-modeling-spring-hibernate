package com.ghailene.recipeappjpadatamodelingspringhibernate.repositories;

import com.ghailene.recipeappjpadatamodelingspringhibernate.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.Option;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
/** spring integration tes **/
//@RunWith(SpringRunner.class)   deprecated in spring 5 and replaced by ExtendWith
@ExtendWith(SpringExtension.class)
@DataJpaTest
class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByDescription() {

        Optional<UnitOfMeasure> unitOfMeasure=unitOfMeasureRepository.findByDescription("Teaspoon");

        assertEquals("Teaspoon",unitOfMeasure.get().getDescription());

    }

    @Test
    void findByDescriptionCup() {

        Optional<UnitOfMeasure> unitOfMeasure=unitOfMeasureRepository.findByDescription("Cup");

        assertEquals("Cup",unitOfMeasure.get().getDescription());

    }
}