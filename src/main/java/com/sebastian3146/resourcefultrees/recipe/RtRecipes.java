package com.sebastian3146.resourcefultrees.recipe;

import com.sebastian3146.resourcefultrees.ResourcefulTrees;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RtRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(ResourcefulTrees.MOD_ID, GemPolishingRecipe.Serializer.ID),
            GemPolishingRecipe.Serializer.INSTANCE);
        
        Registry.register(Registries.RECIPE_TYPE, new Identifier(ResourcefulTrees.MOD_ID, GemPolishingRecipe.Type.ID),
            GemPolishingRecipe.Type.INSTANCE);
    }    
}
