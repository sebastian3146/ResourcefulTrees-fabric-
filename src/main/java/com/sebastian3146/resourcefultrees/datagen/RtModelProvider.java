package com.sebastian3146.resourcefultrees.datagen;

import com.sebastian3146.resourcefultrees.block.RtBlocks;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

public class RtModelProvider extends FabricModelProvider {
    public RtModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(RtBlocks.COAL_LEAVE);
        blockStateModelGenerator.registerTintableCross(RtBlocks.COAL_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerSimpleCubeAll(RtBlocks.COPPER_LEAVE);
        blockStateModelGenerator.registerTintableCross(RtBlocks.COPPER_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerSimpleCubeAll(RtBlocks.DIAMOND_LEAVE);
        blockStateModelGenerator.registerTintableCross(RtBlocks.DIAMOND_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerSimpleCubeAll(RtBlocks.EMERALD_LEAVE);
        blockStateModelGenerator.registerTintableCross(RtBlocks.EMERALD_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerSimpleCubeAll(RtBlocks.GOLD_LEAVE);
        blockStateModelGenerator.registerTintableCross(RtBlocks.GOLD_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerSimpleCubeAll(RtBlocks.IRON_LEAVE);
        blockStateModelGenerator.registerTintableCross(RtBlocks.IRON_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerSimpleCubeAll(RtBlocks.LAPISLAZULI_LEAVE);
        blockStateModelGenerator.registerTintableCross(RtBlocks.LAPISLAZULI_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerSimpleCubeAll(RtBlocks.NETHERRITE_SCRAP_LEAVE);
        blockStateModelGenerator.registerTintableCross(RtBlocks.NETHERRITE_SCRAP_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerSimpleCubeAll(RtBlocks.REDSTONE_LEAVE);
        blockStateModelGenerator.registerTintableCross(RtBlocks.REDSTONE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerSimpleCubeAll(RtBlocks.QUARZ_LEAVE);
        blockStateModelGenerator.registerTintableCross(RtBlocks.QUARZ_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        //blockStateModelGenerator.registerSimpleState(RtBlocks.GEM_POLISHING_STATION);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    }
    
}
