package com.example.sprinInAction.Controllers;

import java.util.Arrays;
import java.util.List;

import com.example.sprinInAction.Pojo.Ingredient;
import com.example.sprinInAction.Pojo.Ingredient.*;
import com.example.sprinInAction.Pojo.Taco;
import com.example.sprinInAction.Service.DesignTacoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {
    @Autowired
    DesignTacoService designTacoService;
    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients =designTacoService.getIngredients();
        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    designTacoService.filterByType(ingredients, type));
        }
        model.addAttribute("design", new Taco());
        return "design";
    }
}