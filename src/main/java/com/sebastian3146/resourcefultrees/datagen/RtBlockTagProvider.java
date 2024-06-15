package com.sebastian3146.resourcefultrees.datagen;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;

public class RtBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public RtBlockTagProvider(FabricDataOutput output, CompletableFuture<WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(WrapperLookup arg) {
        //getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
    }
    
}
