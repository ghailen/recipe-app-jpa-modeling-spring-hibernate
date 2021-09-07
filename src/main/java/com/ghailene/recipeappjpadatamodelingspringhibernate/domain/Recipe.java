package com.ghailene.recipeappjpadatamodelingspringhibernate.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    @Lob
    private String directions;

    //recipe gonna have many ingredients
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();
    @Lob
    private Byte[] image;
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    // many to many on va creer une table intermidaire qui s'appelle recipe_category ,si on fait pas @jointable il aura une creation de deux table intermdiaire qui est faux
    // c'est deux faux table vont etre crée est contenir deux champs recipe_id et category_id mais nous on va creer une seule avec id recipe_id et category_id
    @ManyToMany
    @JoinTable(name="recipe_category",joinColumns= @JoinColumn(name="recipe_id"),inverseJoinColumns = @JoinColumn(name="category_id"))
    private Set<Category> categories = new HashSet<>();

}
