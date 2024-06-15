package com.sebastian3146.resourcefultrees.world.tree;

import net.minecraft.block.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.Optional;

import com.sebastian3146.resourcefultrees.world.RtConfiguredFeatures;

public class RtSaplingGenerator {
    public static final SaplingGenerator COAL_SAPLING = saplingGeneratorResourcefulTrees("coal_tree", RtConfiguredFeatures.COAL_TREE_KEY);
    public static final SaplingGenerator COPPER_SAPLING = saplingGeneratorResourcefulTrees("copper_tree", RtConfiguredFeatures.COPPER_TREE_KEY);
    public static final SaplingGenerator DIAMOND_SAPLING = saplingGeneratorResourcefulTrees("diamond_tree", RtConfiguredFeatures.DIAMOND_TREE_KEY);
    public static final SaplingGenerator EMERALD_SAPLING = saplingGeneratorResourcefulTrees("emerald_tree", RtConfiguredFeatures.EMERALD_TREE_KEY);
    public static final SaplingGenerator GOLD_SAPLING = saplingGeneratorResourcefulTrees("gold_tree", RtConfiguredFeatures.GOLD_TREE_KEY);
    public static final SaplingGenerator IRON_SAPLING = saplingGeneratorResourcefulTrees("iron_tree", RtConfiguredFeatures.IRON_TREE_KEY);
    public static final SaplingGenerator LAPISLAZULI_SAPLING = saplingGeneratorResourcefulTrees("lapislazuli_tree", RtConfiguredFeatures.LAPISLAZULI_TREE_KEY);
    public static final SaplingGenerator NETHERRITE_SCRAP_SAPLING = saplingGeneratorResourcefulTrees("netherrite_scrap_tree", RtConfiguredFeatures.NETHERRITE_SCRAP_TREE_KEY);
    public static final SaplingGenerator REDSTONE_SAPLING = saplingGeneratorResourcefulTrees("redstone_tree", RtConfiguredFeatures.REDSTONE_TREE_KEY);
    public static final SaplingGenerator QUARZ_SAPLING = saplingGeneratorResourcefulTrees("quarz_tree", RtConfiguredFeatures.QUARZ_TREE_KEY);

    public static SaplingGenerator saplingGeneratorResourcefulTrees(String id, RegistryKey<ConfiguredFeature<?, ?>> key) {
        return new SaplingGenerator(id, 0.1f, Optional.empty(),
                        Optional.empty(),
                        Optional.of(key),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty());
    }
}
