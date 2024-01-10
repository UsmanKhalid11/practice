package com.example.sprinInAction.Service;

import com.example.sprinInAction.Pojo.Ingredient;

import com.example.sprinInAction.Pojo.Ingredient.*;

import java.util.List;

public interface DesignTacoService {
    public List<Ingredient> filterByType(List<Ingredient>  ingredient,Type type);
    public List<Ingredient> getIngredients();
}
