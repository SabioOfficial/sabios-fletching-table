package net.sabio.sabios_fletching_table.mixin;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.sabio.sabios_fletching_table.screen.FletchingTableScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractBlock.class)
public abstract class FletchingTableMixin {
    @Inject(method = "onUse", at = @At("HEAD"), cancellable = true)
    private void openFletchingTableGui(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit, CallbackInfoReturnable<ActionResult> cir) {
        if (state.isOf(Blocks.FLETCHING_TABLE)) {
            if (!world.isClient()) {
                player.openHandledScreen(new SimpleNamedScreenHandlerFactory((syncId, playerInventory, player1) -> new FletchingTableScreenHandler(syncId, playerInventory), Text.translatable("container.fletching_table")));
            }
            cir.setReturnValue(ActionResult.SUCCESS);
        }
    }
}
