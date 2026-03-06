package io.github.andriyko69.enderlens.mixin.client.accessor;

import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(Screen.class)
public interface ScreenAccessor {
    @Accessor("renderables")
    List<Renderable> enderlens$getRenderables();

    @Accessor("children")
    List<GuiEventListener> enderlens$getChildren();

    @Accessor("narratables")
    List<NarratableEntry> enderlens$getNarratables();
}