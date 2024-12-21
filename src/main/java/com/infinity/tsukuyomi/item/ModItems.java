package com.infinity.tsukuyomi.item;

import com.infinity.tsukuyomi.InfinityTsukuyomi;
import com.infinity.tsukuyomi.entity.ModEntities;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    // Регистрация яйца спавна Мадары
    public static final Item MADARA_SPAWN_EGG = new SpawnEggItem(
            ModEntities.MADARA, // Сущность для спавна
            0x4C1A1A,           // Основной цвет яйца (тёмный бордовый)
            0xFFFFFF,           // Вторичный цвет яйца (белый)
            new FabricItemSettings()
    );

    public static void registerItems() {
        InfinityTsukuyomi.LOGGER.info("Registering items...");
        // Регистрируем яйцо спавна
        Registry.register(Registries.ITEM, new Identifier(InfinityTsukuyomi.MOD_ID, "madara_spawn_egg"), MADARA_SPAWN_EGG);
        InfinityTsukuyomi.LOGGER.info("Items registered!");
    }
}
