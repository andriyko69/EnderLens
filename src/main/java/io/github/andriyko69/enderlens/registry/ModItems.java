package io.github.andriyko69.enderlens.registry;

import io.github.andriyko69.enderlens.EnderLens;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@EventBusSubscriber(modid = EnderLens.MOD_ID)
public final class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(EnderLens.MOD_ID);

    public static final DeferredItem<Item> ENDER_LENS = ITEMS.register(
            "ender_lens",
            () -> new BlockItem(ModBlocks.ENDER_LENS.get(), new Item.Properties())
    );

    @SubscribeEvent
    public static void buildTabContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ENDER_LENS);
        }
    }

    private ModItems() {
    }

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}