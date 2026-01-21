package net.sabio.sabios_fletching_table;

import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.sabio.sabios_fletching_table.screen.FletchingTableScreenHandler;

public class sabios_fletching_table implements ModInitializer {
    public static final String MOD_ID = "sabios_fletching_table";

    public static final ScreenHandlerType<FletchingTableScreenHandler> FLETCHING_TABLE_SCREEN_HANDLER = new ScreenHandlerType<>(FletchingTableScreenHandler::new, FeatureFlags.VANILLA_FEATURES);

    @Override
    public void onInitialize() {
        Registry.register(Registries.SCREEN_HANDLER, Identifier.of(MOD_ID, "fletching_table"), FLETCHING_TABLE_SCREEN_HANDLER);
    }
}
