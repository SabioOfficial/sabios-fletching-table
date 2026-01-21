package net.sabio.sabios_fletching_table.client;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.sabio.sabios_fletching_table.sabios_fletching_table;
import net.sabio.sabios_fletching_table.screen.FletchingTableScreen;

public class sabios_fletching_tableClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        HandledScreens.register(sabios_fletching_table.FLETCHING_TABLE_SCREEN_HANDLER, FletchingTableScreen::new);
    }
}
