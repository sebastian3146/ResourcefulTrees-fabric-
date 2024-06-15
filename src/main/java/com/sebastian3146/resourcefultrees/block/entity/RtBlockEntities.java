package com.sebastian3146.resourcefultrees.block.entity;

import com.sebastian3146.resourcefultrees.ResourcefulTrees;
import com.sebastian3146.resourcefultrees.block.RtBlocks;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RtBlockEntities {
    public static final BlockEntityType<GemPolishingStationBlockEntity> GEM_POLISHING_STATION_BLOCK_ENTITY =
        Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(ResourcefulTrees.MOD_ID, "gem_polishing_be"),
            FabricBlockEntityTypeBuilder.create(GemPolishingStationBlockEntity::new,
                RtBlocks.GEM_POLISHING_STATION).build());

    public static void registerBlockEntities() {
        ResourcefulTrees.LOGGER.info("Registering Block Entities for " + ResourcefulTrees.MOD_ID);
    }
}
