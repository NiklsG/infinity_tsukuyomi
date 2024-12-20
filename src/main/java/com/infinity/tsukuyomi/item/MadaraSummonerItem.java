package com.infinity.tsukuyomi.item;

import com.infinity.tsukuyomi.entity.MadaraEntity;
import com.infinity.tsukuyomi.entity.ModEntities;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MadaraSummonerItem extends Item {

    public MadaraSummonerItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();

        if (!world.isClient) {
            MadaraEntity madara = new MadaraEntity(ModEntities.MADARA, world);
            madara.refreshPositionAndAngles(pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, 0, 0);
            world.spawnEntity(madara);
        }

        return ActionResult.SUCCESS;
    }
}
