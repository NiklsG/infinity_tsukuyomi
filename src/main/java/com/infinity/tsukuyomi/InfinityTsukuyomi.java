package com.infinity.tsukuyomi;

import com.infinity.tsukuyomi.entity.ModEntities;
import com.infinity.tsukuyomi.item.MoonEyeItem;
import com.infinity.tsukuyomi.render.MadaraRenderer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InfinityTsukuyomi implements ModInitializer {

	public static final String MOD_ID = "infinity_tsukuyomi";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static boolean isTsukuyomiActive = false;

	public static final Item Moon_eye = new MoonEyeItem(new Item.Settings().maxCount(1));

	@Override
	public void onInitialize() {
		// Регистрируем предмет
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "moon_eye"), Moon_eye);

		LOGGER.info("Infinity Tsukuyomi Mod initialized!");

		// Регистрируем рендерер
		EntityRendererRegistry.register(ModEntities.MADARA, MadaraRenderer::new);

		// Регистрируем слой модели с текстурой для Мадары
		EntityModelLayerRegistry.registerModelLayer(
				MadaraRenderer.MADARA_LAYER,
				MadaraRenderer::createModelData
		);
	}
}
