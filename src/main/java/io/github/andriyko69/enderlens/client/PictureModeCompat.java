package io.github.andriyko69.enderlens.client;

import io.github.andriyko69.enderlens.registry.ModSounds;
import mod.icanttellyou.picturemode.client.gui.PictureModeScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public final class PictureModeCompat {
    private PictureModeCompat() {
    }

    public static void openFromBlock(Level level, Player player) {
        Minecraft mc = Minecraft.getInstance();

        if (mc.player == null) {
            return;
        }

        level.playLocalSound(
                player.getX(), player.getY(), player.getZ(),
                ModSounds.ENDER_LENS_OPEN.get(),
                SoundSource.BLOCKS,
                1.0F,
                1.0F,
                false
        );

        mc.setScreen(new PictureModeScreen(mc.screen));
    }
}