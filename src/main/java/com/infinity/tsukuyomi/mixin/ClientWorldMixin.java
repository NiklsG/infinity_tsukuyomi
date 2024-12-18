package com.infinity.tsukuyomi.mixin;

import com.infinity.tsukuyomi.InfinityTsukuyomi;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientWorld.class)
public class ClientWorldMixin {

    @Inject(method = "getSkyColor", at = @At("HEAD"), cancellable = true)
    private void modifySkyColor(Vec3d cameraPos, float tickDelta, CallbackInfoReturnable<Vec3d> cir) {
        if (InfinityTsukuyomi.isTsukuyomiActive) {
            // Красный цвет неба при активации
            cir.setReturnValue(new Vec3d(0.6, 0.1, 0.1));
        }
    }
}
