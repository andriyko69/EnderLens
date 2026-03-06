package io.github.andriyko69.enderlens.mixin.client;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(PauseScreen.class)
public abstract class PauseScreenRemovePictureModeButtonMixin extends Screen {
    protected PauseScreenRemovePictureModeButtonMixin(Component title) {
        super(title);
    }

    @Inject(method = "createPauseMenu", at = @At("TAIL"))
    private void enderlens$removePictureModeButton(CallbackInfo ci) {
        Component target = Component.translatable("gui.picturemode");

        ScreenAccessor accessor = (ScreenAccessor) this;

        List<GuiEventListener> children = accessor.enderlens$getChildren();
        List<Renderable> renderables = accessor.enderlens$getRenderables();
        List<NarratableEntry> narratables = accessor.enderlens$getNarratables();

        children.removeIf(listener ->
                listener instanceof Button button && button.getMessage().equals(target)
        );

        renderables.removeIf(renderable ->
                renderable instanceof Button button && button.getMessage().equals(target)
        );

        narratables.removeIf(entry ->
                entry instanceof Button button && button.getMessage().equals(target)
        );
    }
}
