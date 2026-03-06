package io.github.andriyko69.enderlens;

import io.github.andriyko69.enderlens.registry.ModBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;

@SuppressWarnings("deprecation")
public final class EnderLensClient {
    private EnderLensClient() {
    }

    public static void init() {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ENDER_LENS.get(), RenderType.cutout());
    }
}
