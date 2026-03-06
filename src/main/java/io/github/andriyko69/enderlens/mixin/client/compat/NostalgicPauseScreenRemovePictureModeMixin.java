package io.github.andriyko69.enderlens.mixin.client.compat;

import mod.adrenix.nostalgic.client.gui.screen.vanilla.pause.NostalgicPauseScreen;
import mod.adrenix.nostalgic.client.gui.widget.dynamic.DynamicWidget;
import mod.adrenix.nostalgic.util.common.array.UniqueArrayList;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.lang.reflect.Method;

@Mixin(NostalgicPauseScreen.class)
public abstract class NostalgicPauseScreenRemovePictureModeMixin {
    @Shadow
    @Final
    private UniqueArrayList<DynamicWidget<?, ?>> widgets;

    @Inject(method = "init()V", at = @At("TAIL"))
    private void enderlens$removePictureModeButton(CallbackInfo ci) {
        Component target = Component.translatable("gui.picturemode");

        this.widgets.removeIf(widget -> {
            Component title = enderlens$getTitle(widget);
            return title != null && title.equals(target);
        });
    }

    @Unique
    private static Component enderlens$getTitle(Object widget) {
        try {
            Method method = widget.getClass().getMethod("getTitle");
            Object result = method.invoke(widget);
            return result instanceof Component component ? component : null;
        } catch (ReflectiveOperationException ignored) {
            return null;
        }
    }
}