package com.ghailene.recipeappjpadatamodelingspringhibernate.controllers;

import com.ghailene.recipeappjpadatamodelingspringhibernate.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {

        model.addAttribute("recipes", recipeService.getRecipes());

        /*Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        System.out.println("Cat id is : " + categoryOptional.get().getId());
        System.out.println("UOM id is : " + unitOfMeasureOptional.get().getId());*/
        return "index";

    }

}
