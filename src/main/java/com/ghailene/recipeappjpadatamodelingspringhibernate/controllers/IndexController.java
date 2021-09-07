package com.ghailene.recipeappjpadatamodelingspringhibernate.controllers;

import com.ghailene.recipeappjpadatamodelingspringhibernate.domain.Category;
import com.ghailene.recipeappjpadatamodelingspringhibernate.domain.UnitOfMeasure;
import com.ghailene.recipeappjpadatamodelingspringhibernate.repositories.CategoryRepository;
import com.ghailene.recipeappjpadatamodelingspringhibernate.repositories.UnitOfMeasureRepository;
import com.ghailene.recipeappjpadatamodelingspringhibernate.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {
    private final RecipeService recipeService;
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;


    public IndexController(RecipeService recipeService, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeService = recipeService;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model) {

        model.addAttribute("recipes",recipeService.getRecipes());

        /*Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        System.out.println("Cat id is : " + categoryOptional.get().getId());
        System.out.println("UOM id is : " + unitOfMeasureOptional.get().getId());*/
        return "index";

    }

}
