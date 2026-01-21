package net.sabio.sabios_fletching_table.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.sabio.sabios_fletching_table.sabios_fletching_table;

public class FletchingTableScreenHandler extends ScreenHandler {
    public FletchingTableScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(sabios_fletching_table.FLETCHING_TABLE_SCREEN_HANDLER, syncId);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }
}
