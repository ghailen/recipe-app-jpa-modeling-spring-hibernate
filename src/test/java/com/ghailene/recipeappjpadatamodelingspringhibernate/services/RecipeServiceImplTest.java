package com.ghailene.recipeappjpadatamodelingspringhibernate.services;

import com.ghailene.recipeappjpadatamodelingspringhibernate.converters.RecipeCommandToRecipe;
import com.ghailene.recipeappjpadatamodelingspringhibernate.converters.RecipeToRecipeCommand;
import com.ghailene.recipeappjpadatamodelingspringhibernate.domain.Recipe;
import com.ghailene.recipeappjpadatamodelingspringhibernate.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }


    @Test
    void getRecipes() {

        Recipe recipe = new Recipe();
        HashSet recipesData = new HashSet();
        recipesData.add(recipe);

        Mockito.when(recipeService.getRecipes()).thenReturn(recipesData);


        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(recipes.size(), 1);
        Mockito.verify(recipeRepository, Mockito.times(1)).findAll();
        Mockito.verify(recipeRepository, Mockito.never()).findById(Mockito.anyLong());

    }

    @Test
    public void getRecipeByIdTest() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        Mockito.when(recipeRepository.findById(Mockito.anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.findById(1L);

        // assertNotNull("Null recipe returned", recipeReturned);
        Mockito.verify(recipeRepository, Mockito.times(1)).findById(Mockito.anyLong());
        Mockito.verify(recipeRepository, Mockito.never()).findAll();
    }

    @Test
    public void testDeleteById() throws Exception {

        //given
        Long idToDelete = Long.valueOf(2L);

        //when
        recipeService.deleteById(idToDelete);

        //no 'when', since method has void return type

        //then
        Mockito.verify(recipeRepository, Mockito.times(1)).deleteById(Mockito.anyLong());
    }
}