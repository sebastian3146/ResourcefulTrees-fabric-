# Custom Tree

## Classes needed

WorldGenerator
ConfiguredFeatures
Blocks
SaplingGenerator

## Folder Structure
resourcefultrees
    block
        RtBlocks.java
    datagen
        RtWorldGenerator.java
    world
        tree
            RtSaplingGenerator.java
    ResourcefulTrees.java
    ResourcefulTreesDataGenerator.java



### RtWorldGenerator
```java
import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;

public class RtWorldGenerator extends FabricDynamicRegistryProvider {
    public RtWorldGenerator(FabricDataOutput output, CompletableFuture<WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(WrapperLookup registries, Entries entries) {
        entries.addAll(registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE));
        entries.addAll(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE));
    }

    @Override
    public String getName() {
        return "World gen";
    }
}
```

### RtConfiguredFeatures
```java
import com.sebastian3146.resourcefultrees.ResourcefulTrees;
import com.sebastian3146.resourcefultrees.block.RtBlocks;

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
    
    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, COAL_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.OAK_LOG),
                new StraightTrunkPlacer(5, 4, 3),
                BlockStateProvider.of(RtBlocks.COAL_LEAVE),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
                new TwoLayersFeatureSize(1, 0, 2)).build());
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(ResourcefulTrees.MOD_ID, name));
    }
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature(feature, configuration));
    }
}
```

### RtBlocks
```java
import com.sebastian3146.resourcefultrees.ResourcefulTrees;
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
    public static final Block COAL_SAPLING = registerBlock("coal_sapling", new SaplingBlock(RtSaplingGenerator.COAL, 
    FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(ResourcefulTrees.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(ResourcefulTrees.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
}
```

### RtSaplingGenerator
```java
import com.sebastian3146.resourcefultrees.world.RtConfiguredFeatures;

import net.minecraft.block.SaplingGenerator;
import java.util.Optional;

public class RtSaplingGenerator {
    public static final SaplingGenerator COAL =
        new SaplingGenerator("coal_tree", 0.1f, Optional.empty(),
                Optional.empty(),
                Optional.of(RtConfiguredFeatures.COAL_TREE_KEY),
                Optional.empty(),
                Optional.empty(),
                Optional.empty());
}
```

### ResourcefulTrees
```java
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sebastian3146.resourcefultrees.block.RtBlocks;

public class ResourcefulTrees implements ModInitializer {
	public static final String MOD_ID = "resourcefultrees";
    public static final Logger LOGGER = LoggerFactory.getLogger("resourcefultrees");

	@Override
	public void onInitialize() {
		RtBlocks.registerModBlocks();
		
		FlammableBlockRegistry.getDefaultInstance().add(RtBlocks.COAL_LEAVE, 30, 60);
	}
}
```

### ResourcefulTreesDataGenerator
```java
import com.sebastian3146.resourcefultrees.datagen.RtBlockTagProvider;
import com.sebastian3146.resourcefultrees.datagen.RtItemTagProvider;
import com.sebastian3146.resourcefultrees.datagen.RtLootTableProvider;
import com.sebastian3146.resourcefultrees.datagen.RtModelProvider;
import com.sebastian3146.resourcefultrees.datagen.RtRecipeProvider;
import com.sebastian3146.resourcefultrees.datagen.RtWorldGenerator;
import com.sebastian3146.resourcefultrees.world.RtConfiguredFeatures;
import com.sebastian3146.resourcefultrees.world.RtPlacedFeatures;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class ResourcefulTreesDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(RtWorldGenerator::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, RtConfiguredFeatures::boostrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, RtPlacedFeatures::boostrap);
	}
}
```

