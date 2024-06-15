package com.sebastian3146.resourcefultrees.screen;

import com.sebastian3146.resourcefultrees.ResourcefulTrees;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class RtScreenHandler {
    public static final ScreenHandlerType<GemPolishingScreenHandler> GEM_POLISHING_HANDLER =
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(ResourcefulTrees.MOD_ID, "gem_polishing")
            , new ExtendedScreenHandlerType<>(GemPolishingScreenHandler::new));

    public static void registerScreenHandlers() {
        ResourcefulTrees.LOGGER.info("Registering Screen Handlers for" + ResourcefulTrees.MOD_ID);
    }
}
