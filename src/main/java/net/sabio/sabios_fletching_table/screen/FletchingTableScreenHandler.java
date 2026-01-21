package net.sabio.sabios_fletching_table.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.sabio.sabios_fletching_table.sabios_fletching_table;

public class FletchingTableScreenHandler extends ScreenHandler {
    private final SimpleInventory inventory;

    public FletchingTableScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(sabios_fletching_table.FLETCHING_TABLE_SCREEN_HANDLER, syncId);
        checkSize(new SimpleInventory(3), 3);
        this.inventory = new SimpleInventory(3);
        inventory.onOpen(playerInventory.player);

        this.addSlot(new Slot(inventory, 0, 27, 47));
        this.addSlot(new Slot(inventory, 1, 76, 47));
        this.addSlot(new Slot(inventory, 2, 134, 47));

        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }

        for (int col = 0; col < 9; ++col) {
            this.addSlot(new Slot(playerInventory, col, 8 + col * 18, 142));
        }
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < 3) {
                if (!this.insertItem(originalStack, 3, 39, true)) return ItemStack.EMPTY;
            } else {
                if (!this.insertItem(originalStack, 0, 2, false)) return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) slot.setStack(ItemStack.EMPTY);
            else slot.markDirty();
        }
        return newStack;
    }
}
