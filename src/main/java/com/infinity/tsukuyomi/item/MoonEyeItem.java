package com.infinity.tsukuyomi.item;

import com.infinity.tsukuyomi.InfinityTsukuyomi;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
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

                InfinityTsukuyomi.isTsukuyomiActive = false;

                player.sendMessage(
                        Text.literal("Infinite Tsukuyomi").styled(style -> style.withColor(TextColor.fromRgb(0xFF0000))) // Красный цвет
                                .append(Text.literal(" деактивирован!").styled(style -> style.withColor(TextColor.fromRgb(0x00FF00)))), // Зеленый цвет
                        true);
            } else {

                InfinityTsukuyomi.isTsukuyomiActive = true;


                serverWorld.setTimeOfDay(15000);

                player.sendMessage(
                        Text.literal("Infinite Tsukuyomi").styled(style -> style.withColor(TextColor.fromRgb(0xFF0000))) // Красный цвет
                                .append(Text.literal(" активирован!").styled(style -> style.withColor(TextColor.fromRgb(0x00FF00)))), // Зеленый цвет
                        true);
            }
        }
        return TypedActionResult.success(player.getStackInHand(hand));
    }
}
