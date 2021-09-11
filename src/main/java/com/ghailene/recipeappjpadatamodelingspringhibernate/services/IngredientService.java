package com.ghailene.recipeappjpadatamodelingspringhibernate.services;

import com.ghailene.recipeappjpadatamodelingspringhibernate.commands.IngredientCommand;

public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
    IngredientCommand saveIngredientCommand(IngredientCommand command);
    void deleteById(Long recipeId, Long idToDelete);
}
