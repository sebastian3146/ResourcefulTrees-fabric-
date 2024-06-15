package com.sebastian3146.resourcefultrees.item;

import com.sebastian3146.resourcefultrees.ResourcefulTrees;
import com.sebastian3146.resourcefultrees.block.RtBlocks;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class RtItemGroups {
    public static final ItemGroup RESOURCE_TREES_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ResourcefulTrees.MOD_ID, "resourceful_trees"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.resourceful_trees"))
                    .icon(() -> new ItemStack(RtBlocks.COAL_SAPLING)).entries((displayContext, entries) -> {
                        //SAPLINGS
                        entries.add(RtBlocks.COAL_SAPLING);
                        entries.add(RtBlocks.COPPER_SAPLING);
                        entries.add(RtBlocks.DIAMOND_SAPLING);
                        entries.add(RtBlocks.EMERALD_SAPLING);
                        entries.add(RtBlocks.GOLD_SAPLING);
                        entries.add(RtBlocks.IRON_SAPLING);
                        entries.add(RtBlocks.LAPISLAZULI_SAPLING);
                        entries.add(RtBlocks.NETHERRITE_SCRAP_SAPLING);
                        entries.add(RtBlocks.REDSTONE_SAPLING);
                        entries.add(RtBlocks.QUARZ_SAPLING);

                        //LEAVES
                        entries.add(RtBlocks.COAL_LEAVE);
                        entries.add(RtBlocks.COPPER_LEAVE);
                        entries.add(RtBlocks.DIAMOND_LEAVE);
                        entries.add(RtBlocks.EMERALD_LEAVE);
                        entries.add(RtBlocks.GOLD_LEAVE);
                        entries.add(RtBlocks.IRON_LEAVE);
                        entries.add(RtBlocks.LAPISLAZULI_LEAVE);
                        entries.add(RtBlocks.NETHERRITE_SCRAP_LEAVE);
                        entries.add(RtBlocks.REDSTONE_LEAVE);
                        entries.add(RtBlocks.QUARZ_LEAVE);
                    }).build());


    public static void registerItemGroups() {
        ResourcefulTrees.LOGGER.info("Registering Item Groups for " + ResourcefulTrees.MOD_ID);
    }
}

