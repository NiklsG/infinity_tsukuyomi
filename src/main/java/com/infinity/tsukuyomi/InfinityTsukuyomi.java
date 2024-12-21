package com.infinity.tsukuyomi;

import com.infinity.tsukuyomi.item.ModCreativeTabs;
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

import static com.infinity.tsukuyomi.item.ModItems.MADARA_SPAWN_EGG;

public class InfinityTsukuyomi implements ModInitializer {

	public static final String MOD_ID = "infinity_tsukuyomi";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static boolean isTsukuyomiActive = false;
	public static final Item Moon_eye = new MoonEyeItem(new Item.Settings().maxCount(1));

	@Override
	public void onInitialize() {
		// Регистрация креативной вкладки
		ModCreativeTabs.registerCreativeTab();

		// Регистрация предметов
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "moon_eye"), Moon_eye);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "madara_spawn_egg"), MADARA_SPAWN_EGG);

		// Регистрация сущностей
		ModEntities.registerEntities();

		// Регистрация рендера сущностей
		EntityRendererRegistry.register(ModEntities.MADARA, MadaraRenderer::new);

		// Регистрация модели сущности
		EntityModelLayerRegistry.registerModelLayer(
				MadaraRenderer.MADARA_LAYER,
				MadaraRenderer::createModelData
		);
		LOGGER.info("Infinity Tsukuyomi Mod initialized!");
	}
}
