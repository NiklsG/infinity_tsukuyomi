package com.infinity.tsukuyomi;

import com.infinity.tsukuyomi.item.KunaiItem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class InfinityTsukuyomiClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Регистрация рендера для KunaiProjectile
        EntityRendererRegistry.register(KunaiItem.KUNAI_PROJECTILE_TYPE, FlyingItemEntityRenderer::new);
    }
}
