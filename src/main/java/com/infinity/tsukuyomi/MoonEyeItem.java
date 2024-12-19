package com.infinity.tsukuyomi;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.server.world.ServerWorld;

public class MoonEyeItem extends Item {

    public MoonEyeItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClient && world instanceof ServerWorld serverWorld) {
            if (InfinityTsukuyomi.isTsukuyomiActive) {
                // Отключаем Infinity Tsukuyomi
                InfinityTsukuyomi.isTsukuyomiActive = false;

                player.sendMessage(Text.literal("Infinite Tsukuyomi деактивирован!"), true);
            } else {
                // Активируем Infinity Tsukuyomi
                InfinityTsukuyomi.isTsukuyomiActive = true;

                // Установить ночь
                serverWorld.setTimeOfDay(15000);

                player.sendMessage(Text.literal("Infinite Tsukuyomi активирован!"), true);
            }
        }
        return TypedActionResult.success(player.getStackInHand(hand));
    }
}
