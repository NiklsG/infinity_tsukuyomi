package com.infinity.tsukuyomi.mixin;

import com.infinity.tsukuyomi.InfinityTsukuyomi;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerWorld.class)
public class ServerWorldMixin {

    /**
     * Блокируем изменение времени, если Tsukuyomi активно.
     */
    @Redirect(
            method = "tickTime",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/world/ServerWorld;setTimeOfDay(J)V"
            )
    )
    private void stopTimeIfTsukuyomiActive(ServerWorld instance, long timeOfDay) {
        if (!InfinityTsukuyomi.isTsukuyomiActive) {
            instance.setTimeOfDay(timeOfDay); // Продолжаем время, если Tsukuyomi не активно
        }
    }
}
