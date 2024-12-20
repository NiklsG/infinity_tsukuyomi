package com.infinity.tsukuyomi.item;

import com.infinity.tsukuyomi.InfinityTsukuyomi;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item MADARA_SUMMONER = new MadaraSummonerItem(new Item.Settings().maxCount(1));

    public static void registerItems() {
        Registry.register(Registries.ITEM, new Identifier(InfinityTsukuyomi.MOD_ID, "madara_summoner"), MADARA_SUMMONER);
    }
}

