package com.infinity.tsukuyomi.mixin;

import com.infinity.tsukuyomi.InfinityTsukuyomi;
import com.infinity.tsukuyomi.client.renderer.CustomMoonRenderer;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin {

    @Inject(
            method = "renderSky(Lnet/minecraft/client/util/math/MatrixStack;Lorg/joml/Matrix4f;FLnet/minecraft/client/render/Camera;ZLjava/lang/Runnable;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/mojang/blaze3d/systems/RenderSystem;setShaderTexture(ILnet/minecraft/util/Identifier;)V",
                    ordinal = 1 // Вызов текстуры луны
            )
    )
    private void replaceMoonTexture(MatrixStack matrices, org.joml.Matrix4f projectionMatrix, float tickDelta, net.minecraft.client.render.Camera camera, boolean thickFog, Runnable fogCallback, CallbackInfo ci) {
        if (InfinityTsukuyomi.isTsukuyomiActive) {
            CustomMoonRenderer.render(matrices); // Вызываем метод рендера из CustomMoonRenderer
        }
    }
}
