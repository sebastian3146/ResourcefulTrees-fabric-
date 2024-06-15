package com.sebastian3146.resourcefultrees.world;

import com.sebastian3146.resourcefultrees.ResourcefulTrees;
import com.sebastian3146.resourcefultrees.block.RtBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class RtConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> COAL_TREE_KEY = registerKey("coal_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COPPER_TREE_KEY = registerKey("copper_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DIAMOND_TREE_KEY = registerKey("diamond_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> EMERALD_TREE_KEY = registerKey("emerald_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GOLD_TREE_KEY = registerKey("gold_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> IRON_TREE_KEY = registerKey("iron_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LAPISLAZULI_TREE_KEY = registerKey("lapislazuli_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHERRITE_SCRAP_TREE_KEY = registerKey("netherrite_scrap_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> REDSTONE_TREE_KEY = registerKey("redstone_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> QUARZ_TREE_KEY = registerKey("quarz_tree");
    
    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, COAL_TREE_KEY, Feature.TREE, standardTree(RtBlocks.COAL_LEAVE).build());
        register(context, COPPER_TREE_KEY, Feature.TREE, standardTree(RtBlocks.COPPER_LEAVE).build());
        register(context, DIAMOND_TREE_KEY, Feature.TREE, standardTree(RtBlocks.DIAMOND_LEAVE).build());
        register(context, EMERALD_TREE_KEY, Feature.TREE, standardTree(RtBlocks.EMERALD_LEAVE).build());
        register(context, GOLD_TREE_KEY, Feature.TREE, standardTree(RtBlocks.GOLD_LEAVE).build());
        register(context, IRON_TREE_KEY, Feature.TREE, standardTree(RtBlocks.IRON_LEAVE).build());
        register(context, LAPISLAZULI_TREE_KEY, Feature.TREE, standardTree(RtBlocks.LAPISLAZULI_LEAVE).build());
        register(context, NETHERRITE_SCRAP_TREE_KEY, Feature.TREE, standardTree(RtBlocks.NETHERRITE_SCRAP_LEAVE).build());
        register(context, REDSTONE_TREE_KEY, Feature.TREE, standardTree(RtBlocks.REDSTONE_LEAVE).build());
        register(context, QUARZ_TREE_KEY, Feature.TREE, standardTree(RtBlocks.QUARZ_LEAVE).build());
    }

    private static TreeFeatureConfig.Builder standardTree(Block leaves) {
        return builder(Blocks.OAK_LOG, leaves, 4, 2, 0, 2).ignoreVines();
    }
    private static TreeFeatureConfig.Builder builder(Block log, Block leaves, int baseHeight, int firstRandomHeight, int secondRandomHeight, int radius) {
        return new TreeFeatureConfig.Builder(
            BlockStateProvider.of(log), 
            new StraightTrunkPlacer(baseHeight, firstRandomHeight, secondRandomHeight), 
            BlockStateProvider.of(leaves), 
            new BlobFoliagePlacer(ConstantIntProvider.create(radius), ConstantIntProvider.create(0), 3),
            new TwoLayersFeatureSize(1, 0, 1));
    }



    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(ResourcefulTrees.MOD_ID, name));
    }
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<FC, F>(feature, configuration));
    }
}
