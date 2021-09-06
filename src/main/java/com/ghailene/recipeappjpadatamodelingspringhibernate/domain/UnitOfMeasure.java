package com.ghailene.recipeappjpadatamodelingspringhibernate.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class UnitOfMeasure {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

}
