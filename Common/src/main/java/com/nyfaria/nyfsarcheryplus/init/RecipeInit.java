package com.nyfaria.nyfsarcheryplus.init;

import com.nyfaria.nyfsarcheryplus.Constants;
import com.nyfaria.nyfsarcheryplus.recipe.AdvancedTippedArrowRecipe;
import com.nyfaria.nyfsarcheryplus.registration.RegistrationProvider;
import com.nyfaria.nyfsarcheryplus.registration.RegistryObject;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;

public class RecipeInit {
    public static final RegistrationProvider<RecipeSerializer<?>> RECIPES = RegistrationProvider.get(Registries.RECIPE_SERIALIZER, Constants.MODID);

    public static final RegistryObject<RecipeSerializer<AdvancedTippedArrowRecipe>> ADVANCED_TIPPED_ARROW = RECIPES.register("advanced_tipped_arrow", () -> new SimpleCraftingRecipeSerializer<>((a,b)->new AdvancedTippedArrowRecipe(a)));

    public static void loadClass() {
    }
}
