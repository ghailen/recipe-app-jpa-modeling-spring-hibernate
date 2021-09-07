package com.ghailene.recipeappjpadatamodelingspringhibernate.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
//mappedBy categories qui est dans la classe recipe le nom de champs
    @ManyToMany(mappedBy="categories",fetch = FetchType.EAGER)
    private Set<Recipe> recipes = new HashSet<>();

}
