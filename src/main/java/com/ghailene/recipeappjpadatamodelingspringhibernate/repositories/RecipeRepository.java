package com.ghailene.recipeappjpadatamodelingspringhibernate.repositories;

import com.ghailene.recipeappjpadatamodelingspringhibernate.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {


}
