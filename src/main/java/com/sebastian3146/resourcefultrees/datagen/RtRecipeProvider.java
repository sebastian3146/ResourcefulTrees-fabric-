package com.sebastian3146.resourcefultrees.datagen;

import com.sebastian3146.resourcefultrees.block.RtBlocks;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class RtRecipeProvider extends FabricRecipeProvider {
    public RtRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        resourceSaplingRecipe(RtBlocks.COAL_SAPLING, Blocks.OAK_SAPLING, Blocks.COAL_BLOCK, exporter);
        resourceSaplingRecipe(RtBlocks.COPPER_SAPLING, Blocks.OAK_SAPLING, Blocks.COPPER_BLOCK, exporter);
        resourceSaplingRecipe(RtBlocks.DIAMOND_SAPLING, Blocks.OAK_SAPLING, Blocks.DIAMOND_BLOCK, exporter);
        resourceSaplingRecipe(RtBlocks.EMERALD_SAPLING, Blocks.OAK_SAPLING, Blocks.EMERALD_BLOCK, exporter);
        resourceSaplingRecipe(RtBlocks.GOLD_SAPLING, Blocks.OAK_SAPLING, Blocks.GOLD_BLOCK, exporter);
        resourceSaplingRecipe(RtBlocks.IRON_SAPLING, Blocks.OAK_SAPLING, Blocks.IRON_BLOCK, exporter);
        resourceSaplingRecipe(RtBlocks.LAPISLAZULI_SAPLING, Blocks.OAK_SAPLING, Blocks.LAPIS_BLOCK, exporter);
        resourceSaplingRecipe(RtBlocks.NETHERRITE_SCRAP_SAPLING, Blocks.OAK_SAPLING, Blocks.ANCIENT_DEBRIS, exporter);
        resourceSaplingRecipe(RtBlocks.REDSTONE_SAPLING, Blocks.OAK_SAPLING, Blocks.REDSTONE_BLOCK, exporter);
        resourceSaplingRecipe(RtBlocks.QUARZ_SAPLING, Blocks.OAK_SAPLING, Blocks.QUARTZ_BLOCK, exporter);
    }
    
    private void resourceSaplingRecipe(Block outputSapling, Block inputSapling, Block inputResource, RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, outputSapling, 1)
            .pattern("BBB")
            .pattern("BSB")
            .pattern("BBB")
            .input('B', inputResource)
            .input('S', inputSapling)
            .criterion(hasItem(inputSapling), conditionsFromItem(inputSapling))
            .criterion(hasItem(inputResource), conditionsFromItem(inputResource))
            .offerTo(exporter, Identifier.of(getRecipeName(outputSapling)));
    }
}
