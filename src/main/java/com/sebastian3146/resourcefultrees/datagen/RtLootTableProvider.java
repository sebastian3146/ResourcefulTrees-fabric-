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
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKeys;

import java.util.concurrent.CompletableFuture;

public class RtLootTableProvider extends FabricBlockLootTableProvider {
    public RtLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
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

    // From the method oakLeavesDrops in the class BlockLootTableGenerator
    public LootTable.Builder resourceLeavesDrops(Block leaves, Block sapling, Item dropResource, float... saplingChance) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.leavesDrops(leaves, sapling, saplingChance)
            .pool(
                LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1.0F))
                    .conditionally(this.createWithoutShearsOrSilkTouchCondition())
                    .with(
                        ((LeafEntry.Builder)this.addSurvivesExplosionCondition(leaves, ItemEntry.builder(dropResource)))
                            .conditionally(TableBonusLootCondition.builder(impl.getOrThrow(Enchantments.FORTUNE), 0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F))
                    )
            );
    }
}
