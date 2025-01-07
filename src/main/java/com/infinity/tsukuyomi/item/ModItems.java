package com.infinity.tsukuyomi.item;

import com.infinity.tsukuyomi.InfinityTsukuyomi;
import com.infinity.tsukuyomi.entity.ModEntities;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    // Регистрация яйца спавна Мадары
    public static final Item MADARA_SPAWN_EGG = new SpawnEggItem(ModEntities.MADARA, 0x4C1A1A, 0xFFFFFF, new FabricItemSettings());

    // Регистрация меча Мадары
    public static final Item MADARA_SWORD = new SwordItem(ToolMaterials.DIAMOND, 12,-2.4f,new FabricItemSettings());

    public static final Item KUNAI = new KunaiItem(new Item.Settings().maxCount(16));

    public static void registerItems() {
        InfinityTsukuyomi.LOGGER.info("Registering items...");

        // Регистрируем яйцо спавна
        Registry.register(Registries.ITEM, new Identifier(InfinityTsukuyomi.MOD_ID, "madara_spawn_egg"), MADARA_SPAWN_EGG);

        // Регистрируем меч Мадары
        Registry.register(Registries.ITEM, new Identifier(InfinityTsukuyomi.MOD_ID, "madara_sword"), MADARA_SWORD);

        Registry.register(Registries.ITEM, new Identifier("infinity_tsukuyomi", "kunai"), KUNAI);

        // Выводим сообщение о том, что все регистрировали (для отладки)
        InfinityTsukuyomi.LOGGER.info("Items registered!");
    }
}
