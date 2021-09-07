package com.ghailene.recipeappjpadatamodelingspringhibernate.services;

import com.ghailene.recipeappjpadatamodelingspringhibernate.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

}
