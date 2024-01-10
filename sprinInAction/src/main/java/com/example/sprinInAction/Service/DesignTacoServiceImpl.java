package com.example.sprinInAction.Service;

import com.example.sprinInAction.Pojo.Ingredient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DesignTacoServiceImpl implements DesignTacoService {
    @Override
    public List<Ingredient> filterByType(List<Ingredient> ingredient, Ingredient.Type type) {
        List<Ingredient> ingredientsOfSpecificType = ingredient.stream().filter(i -> i.getType().equals(type)).collect(Collectors.toList());
        return ingredientsOfSpecificType;

    }

    @Override
    public List<Ingredient> getIngredients() {
        return Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE)
        );
    }
}
