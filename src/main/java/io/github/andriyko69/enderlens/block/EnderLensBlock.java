package io.github.andriyko69.enderlens.block;

import io.github.andriyko69.enderlens.client.PictureModeCompat;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class EnderLensBlock extends TransparentBlock {
    public EnderLensBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected @NotNull ItemInteractionResult useItemOn(
            @NotNull ItemStack stack,
            @NotNull BlockState state,
            Level level,
            @NotNull BlockPos pos,
            @NotNull Player player,
            @NotNull InteractionHand hand,
            @NotNull BlockHitResult hit
    ) {
        if (level.isClientSide) {
            player.swing(hand);
            PictureModeCompat.openFromBlock(level, player);
        }
        return ItemInteractionResult.SUCCESS;
    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(
            @NotNull BlockState state,
            Level level,
            @NotNull BlockPos pos,
            @NotNull Player player,
            @NotNull BlockHitResult hit
    ) {
        if (level.isClientSide) {
            player.swing(InteractionHand.MAIN_HAND);
            PictureModeCompat.openFromBlock(level, player);
        }
        return InteractionResult.SUCCESS;
    }
}