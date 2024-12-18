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
            // Установить ночь
            serverWorld.setTimeOfDay(13000);

            // Выключить дождь
            serverWorld.setWeather(0, 0, false, false);

            // Активировать эффект на клиенте
            InfinityTsukuyomi.isTsukuyomiActive = true;

            player.sendMessage(Text.literal("Infinite Tsukuyomi активирован!"), true);
        }
        return TypedActionResult.success(player.getStackInHand(hand));
    }
}
