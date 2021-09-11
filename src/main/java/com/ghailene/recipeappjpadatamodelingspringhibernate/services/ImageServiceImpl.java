package com.ghailene.recipeappjpadatamodelingspringhibernate.services;

import com.ghailene.recipeappjpadatamodelingspringhibernate.domain.Recipe;
import com.ghailene.recipeappjpadatamodelingspringhibernate.repositories.RecipeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {
    private final RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeService) {

        this.recipeRepository = recipeService;
    }

    @Override
    @Transactional
    public void saveImageFile(Long recipeId, MultipartFile file) {

        try {
            Recipe recipe = recipeRepository.findById(recipeId).get();

            Byte[] byteObjects = new Byte[file.getBytes().length];

            int i = 0;

            for (byte b : file.getBytes()) {
                byteObjects[i++] = b;
            }

            recipe.setImage(byteObjects);

            recipeRepository.save(recipe);
        } catch (IOException e) {
            //todo handle better


            e.printStackTrace();
        }
    }
}