package com.infinity.tsukuyomi;

import com.infinity.tsukuyomi.client.renderer.MadaraRenderer;
import com.infinity.tsukuyomi.entity.ModEntities;
import com.infinity.tsukuyomi.item.ModCreativeTabs;
import com.infinity.tsukuyomi.item.ModItems;
import com.infinity.tsukuyomi.item.MoonEyeItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;
import software.bernie.geckolib.network.GeckoLibNetwork;

public class InfinityTsukuyomi implements ModInitializer {

	public static final String MOD_ID = "infinity_tsukuyomi";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static boolean isTsukuyomiActive = false;
	public static final Item MOON_EYE = new MoonEyeItem(new Item.Settings().maxCount(1));

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Infinity Tsukuyomi Mod...");

		// Регистрация GeckoLib
		GeckoLib.initialize();
		GeckoLibNetwork.registerClientReceiverPackets();

		// Регистрация сущностей
		ModEntities.registerEntities();
		EntityRendererRegistry.register(ModEntities.MADARA, MadaraRenderer::new);

		// Регистрация предметов
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "moon_eye"), MOON_EYE);
		ModItems.registerItems();
		// Регистрация креативной вкладки
		ModCreativeTabs.registerCreativeTab();

		LOGGER.info("Infinity Tsukuyomi Mod initialized!");
	}
}
