package com.sebastian3146.resourcefultrees;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sebastian3146.resourcefultrees.block.RtBlocks;
import com.sebastian3146.resourcefultrees.block.entity.RtBlockEntities;
import com.sebastian3146.resourcefultrees.item.RtItemGroups;
import com.sebastian3146.resourcefultrees.screen.RtScreenHandler;

public class ResourcefulTrees implements ModInitializer {
	public static final String MOD_ID = "resourcefultrees";
    public static final Logger LOGGER = LoggerFactory.getLogger("resourcefultrees");

	@Override
	public void onInitialize() {
		RtBlocks.registerModBlocks();
		RtItemGroups.registerItemGroups();
		RtBlockEntities.registerBlockEntities();
		RtScreenHandler.registerScreenHandlers();
		
		//FlammableBlockRegistry.getDefaultInstance().add(RtBlocks.COAL_LEAVE, 30, 60);
	}
}
