package io.github.andriyko69.enderlens.registry;

import io.github.andriyko69.enderlens.EnderLens;
import io.github.andriyko69.enderlens.block.EnderLensBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(EnderLens.MOD_ID);

    public static final DeferredBlock<Block> ENDER_LENS = BLOCKS.register(
            "ender_lens",
            () -> new EnderLensBlock(BlockBehaviour.Properties.of()
                    .strength(3.0f, 3.0f)
                    .sound(SoundType.STONE)
                    .noOcclusion())
    );

    private ModBlocks() {
    }

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}