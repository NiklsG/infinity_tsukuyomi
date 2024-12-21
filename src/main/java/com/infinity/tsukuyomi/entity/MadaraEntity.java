package com.infinity.tsukuyomi.entity;

import com.infinity.tsukuyomi.InfinityTsukuyomi;
import com.infinity.tsukuyomi.render.animation.Madara_animation;
import net.minecraft.client.render.entity.animation.Animation;
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
    Animation currentAnimation; // Храним текущую анимацию.

    public MadaraEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0D, false)); // Атака в ближнем бою
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true)); // Нацелен на игрока
    }

    public static DefaultAttributeContainer.Builder createMadaraAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 200.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.35)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 15.0)
                .add(EntityAttributes.GENERIC_ARMOR, 10.0);
    }

    @Override
    public void onDeath(DamageSource source) {
        super.onDeath(source);

        if (!this.getWorld().isClient && source.getAttacker() instanceof PlayerEntity player) {
            this.dropStack(new ItemStack(InfinityTsukuyomi.Moon_eye, 1));
        }
    }

    @Override
    public void tick() {
        super.tick();

        PlayerEntity player = this.getWorld().getClosestPlayer(this, 10.0D);
        if (player != null && this.canSee(player)) {
            this.setCurrentAnimation(Madara_animation.walking);
        } else {
            this.setCurrentAnimation(Madara_animation.staying);
        }
    }

    public void setCurrentAnimation(Animation animation) {
        this.currentAnimation = animation;
        // Дополнительная логика анимации может быть добавлена здесь.
    }
}
