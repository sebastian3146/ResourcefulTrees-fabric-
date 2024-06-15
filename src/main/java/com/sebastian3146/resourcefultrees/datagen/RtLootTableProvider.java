package com.sebastian3146.resourcefultrees.datagen;

import com.sebastian3146.resourcefultrees.block.RtBlocks;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.TableBonusLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;

public class RtLootTableProvider extends FabricBlockLootTableProvider {
    public RtLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(RtBlocks.COAL_SAPLING);
        addDrop(RtBlocks.COAL_LEAVE, resourceLeavesDrops(RtBlocks.COAL_LEAVE, RtBlocks.COAL_SAPLING, Items.COAL, 0.1f));
        
        addDrop(RtBlocks.COPPER_SAPLING);
        addDrop(RtBlocks.COPPER_LEAVE, resourceLeavesDrops(RtBlocks.COPPER_LEAVE, RtBlocks.COPPER_SAPLING, Items.RAW_COPPER, 0.1f));

        addDrop(RtBlocks.DIAMOND_SAPLING);
        addDrop(RtBlocks.DIAMOND_LEAVE, resourceLeavesDrops(RtBlocks.DIAMOND_LEAVE, RtBlocks.DIAMOND_SAPLING, Items.DIAMOND, 0.1f));

        addDrop(RtBlocks.EMERALD_SAPLING);
        addDrop(RtBlocks.EMERALD_LEAVE, resourceLeavesDrops(RtBlocks.EMERALD_LEAVE, RtBlocks.EMERALD_SAPLING, Items.EMERALD, 0.1f));

        addDrop(RtBlocks.GOLD_SAPLING);
        addDrop(RtBlocks.GOLD_LEAVE, resourceLeavesDrops(RtBlocks.GOLD_LEAVE, RtBlocks.GOLD_SAPLING, Items.RAW_GOLD, 0.1f));

        addDrop(RtBlocks.IRON_SAPLING);
        addDrop(RtBlocks.IRON_LEAVE, resourceLeavesDrops(RtBlocks.IRON_LEAVE, RtBlocks.IRON_SAPLING, Items.RAW_IRON, 0.1f));

        addDrop(RtBlocks.LAPISLAZULI_SAPLING);
        addDrop(RtBlocks.LAPISLAZULI_LEAVE, resourceLeavesDrops(RtBlocks.LAPISLAZULI_LEAVE, RtBlocks.LAPISLAZULI_SAPLING, Items.LAPIS_LAZULI, 0.1f));

        addDrop(RtBlocks.NETHERRITE_SCRAP_SAPLING);
        addDrop(RtBlocks.NETHERRITE_SCRAP_LEAVE, resourceLeavesDrops(RtBlocks.NETHERRITE_SCRAP_LEAVE, RtBlocks.NETHERRITE_SCRAP_SAPLING, Items.NETHERITE_SCRAP, 0.1f));

        addDrop(RtBlocks.REDSTONE_SAPLING);
        addDrop(RtBlocks.REDSTONE_LEAVE, resourceLeavesDrops(RtBlocks.REDSTONE_LEAVE, RtBlocks.REDSTONE_SAPLING, Items.REDSTONE, 0.1f));

        addDrop(RtBlocks.QUARZ_SAPLING);
        addDrop(RtBlocks.QUARZ_LEAVE, resourceLeavesDrops(RtBlocks.QUARZ_LEAVE, RtBlocks.QUARZ_SAPLING, Items.QUARTZ, 0.1f));
    }

    // From the method oakLeavesDrops
    public LootTable.Builder resourceLeavesDrops(Block leaves, Block dropSapling, Item dropResource, float ... chance) {
        return this.leavesDrops(leaves, dropSapling, chance)
            .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0f))
            .conditionally(WITHOUT_SILK_TOUCH_NOR_SHEARS)
            .with((LootPoolEntry.Builder<?>)
                ((LeafEntry.Builder<?>)this.addSurvivesExplosionCondition(leaves, 
                    ItemEntry.builder(dropResource)))
                        .conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, chance))));
    }
}
