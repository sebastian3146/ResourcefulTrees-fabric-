package com.sebastian3146.resourcefultrees;

import com.sebastian3146.resourcefultrees.block.RtBlocks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;

public class ResourcefulTreesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(RtBlocks.COAL_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RtBlocks.COAL_LEAVE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(RtBlocks.COPPER_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RtBlocks.COPPER_LEAVE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(RtBlocks.DIAMOND_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RtBlocks.DIAMOND_LEAVE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(RtBlocks.EMERALD_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RtBlocks.EMERALD_LEAVE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(RtBlocks.GOLD_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RtBlocks.GOLD_LEAVE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(RtBlocks.IRON_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RtBlocks.IRON_LEAVE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(RtBlocks.LAPISLAZULI_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RtBlocks.LAPISLAZULI_LEAVE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(RtBlocks.NETHERRITE_SCRAP_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RtBlocks.NETHERRITE_SCRAP_LEAVE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(RtBlocks.REDSTONE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RtBlocks.REDSTONE_LEAVE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(RtBlocks.QUARZ_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RtBlocks.QUARZ_LEAVE, RenderLayer.getCutout());

    }
}
