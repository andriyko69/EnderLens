package io.github.andriyko69.enderlens;

import io.github.andriyko69.enderlens.registry.ModBlocks;
import io.github.andriyko69.enderlens.registry.ModItems;
import io.github.andriyko69.enderlens.registry.ModSounds;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;

@Mod(EnderLens.MOD_ID)
public class EnderLens {
    public static final String MOD_ID = "enderlens";

    public EnderLens(IEventBus modEventBus) {
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModSounds.register(modEventBus);

        if (FMLEnvironment.dist.isClient()) {
            modEventBus.addListener(this::onClientSetup);
        }
    }

    private void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(EnderLensClient::init);
    }
}
