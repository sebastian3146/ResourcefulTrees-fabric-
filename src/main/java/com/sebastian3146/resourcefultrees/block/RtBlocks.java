package com.sebastian3146.resourcefultrees.block;

import com.sebastian3146.resourcefultrees.ResourcefulTrees;
import com.sebastian3146.resourcefultrees.block.custom.GemPolishingStationBlock;
import com.sebastian3146.resourcefultrees.world.tree.RtSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SaplingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RtBlocks {

    //SAPLINGS
    public static final Block COAL_SAPLING = registerBlock(
        "coal_sapling",
        new SaplingBlock(
            RtSaplingGenerator.COAL_SAPLING,
            FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)
        )
    );
    public static final Block COPPER_SAPLING = registerBlock(
        "copper_sapling",
        new SaplingBlock(
            RtSaplingGenerator.COPPER_SAPLING,
            FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)
        )
    );
    public static final Block DIAMOND_SAPLING = registerBlock(
        "diamond_sapling",
        new SaplingBlock(
            RtSaplingGenerator.DIAMOND_SAPLING,
            FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)
        )
    );
    public static final Block EMERALD_SAPLING = registerBlock(
        "emerald_sapling",
        new SaplingBlock(
            RtSaplingGenerator.EMERALD_SAPLING,
            FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)
        )
    );
    public static final Block GOLD_SAPLING = registerBlock(
        "gold_sapling",
        new SaplingBlock(
            RtSaplingGenerator.GOLD_SAPLING,
            FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)
        )
    );
    public static final Block IRON_SAPLING = registerBlock(
        "iron_sapling",
        new SaplingBlock(
            RtSaplingGenerator.IRON_SAPLING,
            FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)
        )
    );
    public static final Block LAPISLAZULI_SAPLING = registerBlock(
        "lapislazuli_sapling",
        new SaplingBlock(
            RtSaplingGenerator.LAPISLAZULI_SAPLING,
            FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)
        )
    );
    public static final Block NETHERRITE_SCRAP_SAPLING = registerBlock(
        "netherite_scrap_sapling",
        new SaplingBlock(
            RtSaplingGenerator.NETHERRITE_SCRAP_SAPLING,
            FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)
        )
    );
    public static final Block REDSTONE_SAPLING = registerBlock(
        "redstone_sapling",
        new SaplingBlock(
            RtSaplingGenerator.REDSTONE_SAPLING,
            FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)
        )
    );
    public static final Block QUARZ_SAPLING = registerBlock(
        "quartz_sapling",
        new SaplingBlock(
            RtSaplingGenerator.QUARZ_SAPLING,
            FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)
        )
    );
    //LEAVES
    public static final Block COAL_LEAVE = registerBlock(
        "coal_leaves",
        new Block(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES))
    );
    public static final Block COPPER_LEAVE = registerBlock(
        "copper_leaves",
        new Block(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES))
    );
    public static final Block DIAMOND_LEAVE = registerBlock(
        "diamond_leaves",
        new Block(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES))
    );
    public static final Block EMERALD_LEAVE = registerBlock(
        "emerald_leaves",
        new Block(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES))
    );
    public static final Block GOLD_LEAVE = registerBlock(
        "gold_leaves",
        new Block(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES))
    );
    public static final Block IRON_LEAVE = registerBlock(
        "iron_leaves",
        new Block(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES))
    );
    public static final Block LAPISLAZULI_LEAVE = registerBlock(
        "lapislazuli_leaves",
        new Block(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES))
    );
    public static final Block NETHERRITE_SCRAP_LEAVE = registerBlock(
        "netherite_scrap_leaves",
        new Block(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES))
    );
    public static final Block REDSTONE_LEAVE = registerBlock(
        "redstone_leaves",
        new Block(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES))
    );
    public static final Block QUARZ_LEAVE = registerBlock(
        "quartz_leaves",
        new Block(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES))
    );

    //Model
    public static final Block GEM_POLISHING_STATION = registerBlock(
        "gem_polishing_station",
        new GemPolishingStationBlock(
            FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()
        )
    );

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(
            Registries.BLOCK,
            new Identifier(ResourcefulTrees.MOD_ID, name),
            block
        );
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(
            Registries.ITEM,
            new Identifier(ResourcefulTrees.MOD_ID, name),
            new BlockItem(block, new FabricItemSettings())
        );
    }

    public static void registerModBlocks() {
        ResourcefulTrees.LOGGER.info(
            "Registering ModBlocks for " + ResourcefulTrees.MOD_ID
        );
    }
}
