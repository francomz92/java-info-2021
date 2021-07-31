package com.mapeoClases.ejercicioSiete.config;

import com.mapeoClases.ejercicioSiete.entity.Recipe;
import com.mapeoClases.ejercicioSiete.repository.IngredientRepository;
import com.mapeoClases.ejercicioSiete.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RecipeRuner implements CommandLineRunner {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public void run(String... args) throws Exception {

        Optional<Recipe> recipe = recipeRepository.findById(1L);

        Iterable<Recipe> recipeList = recipeRepository.findByDescripcion("alguna");
    }
}
