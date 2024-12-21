package com.infinity.tsukuyomi.item;

import com.infinity.tsukuyomi.InfinityTsukuyomi;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModCreativeTabs {

    public static final RegistryKey<ItemGroup> INFINITY_TSUKUYOMI_TAB = RegistryKey.of(
            RegistryKeys.ITEM_GROUP,
            new Identifier(InfinityTsukuyomi.MOD_ID, "infinity_tsukuyomi_tab")
    );

    public static void registerCreativeTab() {
        InfinityTsukuyomi.LOGGER.info("Registering creative tab...");

        // Регистрация вкладки через Fabric API
        ItemGroup group = FabricItemGroup.builder()
                .displayName(Text.translatable("itemGroup.infinity_tsukuyomi_tab"))
                .icon(() -> new ItemStack(InfinityTsukuyomi.Moon_eye))
                .entries((enabledFeatures, entries) -> {
                    // Добавляем предметы во вкладку
                    entries.add(InfinityTsukuyomi.Moon_eye); // Глаз луны
                    entries.add(ModItems.MADARA_SPAWN_EGG); // Яйцо призыва Мадары - Вызвает краш майнкрафта
                })
                .build();

        // Регистрируем группу
        Registry.register(Registries.ITEM_GROUP, INFINITY_TSUKUYOMI_TAB.getValue(), group);

        InfinityTsukuyomi.LOGGER.info("Creative tab registered!");
    }
}
