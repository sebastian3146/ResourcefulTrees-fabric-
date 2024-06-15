package com.sebastian3146.resourcefultrees;

import com.sebastian3146.resourcefultrees.datagen.RtBlockTagProvider;
import com.sebastian3146.resourcefultrees.datagen.RtItemTagProvider;
import com.sebastian3146.resourcefultrees.datagen.RtLootTableProvider;
import com.sebastian3146.resourcefultrees.datagen.RtModelProvider;
import com.sebastian3146.resourcefultrees.datagen.RtRecipeProvider;
import com.sebastian3146.resourcefultrees.datagen.RtWorldGenerator;
import com.sebastian3146.resourcefultrees.world.RtConfiguredFeatures;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;


public class ResourcefulTreesDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(RtBlockTagProvider::new);
		pack.addProvider(RtItemTagProvider::new);
		pack.addProvider(RtLootTableProvider::new);
		pack.addProvider(RtModelProvider::new);
		pack.addProvider(RtRecipeProvider::new);
		pack.addProvider(RtWorldGenerator::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, RtConfiguredFeatures::boostrap);
	}
}
