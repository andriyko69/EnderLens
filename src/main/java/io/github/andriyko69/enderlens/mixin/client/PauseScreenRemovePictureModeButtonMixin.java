package io.github.andriyko69.enderlens.mixin.client;

import io.github.andriyko69.enderlens.mixin.client.accessor.ScreenAccessor;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(PauseScreen.class)
public abstract class PauseScreenRemovePictureModeButtonMixin {
    @Inject(method = "init()V", at = @At("TAIL"))
    private void enderlens$afterInit(CallbackInfo ci) {
        enderlens$removePictureModeButton();
    }

    @Unique
    private void enderlens$removePictureModeButton() {
        ScreenAccessor accessor = (ScreenAccessor) this;
        Component target = Component.translatable("gui.picturemode");

        List<Renderable> renderables = accessor.enderlens$getRenderables();
        List<GuiEventListener> children = accessor.enderlens$getChildren();
        List<NarratableEntry> narratables = accessor.enderlens$getNarratables();

        renderables.removeIf(renderable ->
                renderable instanceof AbstractWidget widget &&
                        widget.getMessage().equals(target)
        );

        children.removeIf(listener ->
                listener instanceof AbstractWidget widget &&
                        widget.getMessage().equals(target)
        );

        narratables.removeIf(entry ->
                entry instanceof AbstractWidget widget &&
                        widget.getMessage().equals(target)
        );
    }
}