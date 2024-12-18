package com.infinity.tsukuyomi;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InfinityTsukuyomi implements ModInitializer, ClientModInitializer {

	public static final String MOD_ID = "infinity_tsukuyomi";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static boolean isTsukuyomiActive = false;

	public static final Item Moon_eye = new MoonEyeItem(new Item.Settings().maxCount(1));

	@Override
	public void onInitialize() {
		// Регистрируем предмет
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "moon_eye"), Moon_eye);

		LOGGER.info("Infinity Tsukuyomi Mod initialized!");
	}

	@Override
	public void onInitializeClient() {
		LOGGER.info("Infinity Tsukuyomi Mod client initialized!");
	}
}
