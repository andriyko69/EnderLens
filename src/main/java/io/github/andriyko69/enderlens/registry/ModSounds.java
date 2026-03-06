package io.github.andriyko69.enderlens.registry;

import io.github.andriyko69.enderlens.EnderLens;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(Registries.SOUND_EVENT, EnderLens.MOD_ID);

    public static final Supplier<SoundEvent> ENDER_LENS_OPEN = SOUND_EVENTS.register(
            "block.ender_lens.open",
            () -> SoundEvent.createVariableRangeEvent(
                    ResourceLocation.fromNamespaceAndPath(EnderLens.MOD_ID, "block.ender_lens.open")
            )
    );

    private ModSounds() {
    }

    public static void register(IEventBus modEventBus) {
        SOUND_EVENTS.register(modEventBus);
    }
}
