package com.infinity.tsukuyomi.entity;

import com.infinity.tsukuyomi.InfinityTsukuyomi;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MadaraEntity extends HostileEntity {

    public MadaraEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        // Установить AI задачи
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0D, false)); // Атака в ближнем бою
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true)); // Нацелен на игрока
    }

    public static DefaultAttributeContainer.Builder createMadaraAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 200.0) // Здоровье
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.35) // Скорость
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 15.0) // Урон
                .add(EntityAttributes.GENERIC_ARMOR, 10.0); // Броня
    }

    @Override
    public void onDeath(DamageSource source) {
        super.onDeath(source);

        // Если убил игрок
        if (!this.getWorld().isClient && source.getAttacker() instanceof PlayerEntity player) {
            // Пока только дроп предмета
            this.dropStack(new ItemStack(InfinityTsukuyomi.Moon_eye, 1));
        }
    }
}
