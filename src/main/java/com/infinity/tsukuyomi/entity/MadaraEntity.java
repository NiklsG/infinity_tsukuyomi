package com.infinity.tsukuyomi.entity;

import com.infinity.tsukuyomi.animation.MadaraAnimation;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;


public class MadaraEntity extends PathAwareEntity implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public MadaraEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);

        // Цели и поведение сущности
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0D, false));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder createMadaraAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 500.0) // Большое здоровье для босса
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3) // Скорость передвижения
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 25.0) // Высокий урон
                .add(EntityAttributes.GENERIC_ARMOR, 15.0) // Увеличенная броня
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0); // Иммунитет к отталкиванию
    }

    @Override /// Iris/Oculus & GeckoLib Compat конфликт с анимациями
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "movementController", 10, state -> {
            boolean isMoving = this.getVelocity().lengthSquared() > 0.01;
            AnimationController<?> controller = state.getController();

            // Проверяем текущую анимацию и обновляем ее при необходимости
            String currentAnimation = controller.getCurrentAnimation() != null
                    ? controller.getCurrentAnimation().animation().name()
                    : null;

            if (isMoving && !"animation.madara.walking".equals(currentAnimation)) {
                controller.setAnimation(MadaraAnimation.walking);
            } else if (!isMoving && !"animation.madara.staying".equals(currentAnimation)) {
                controller.setAnimation(MadaraAnimation.staying);
            }

            return PlayState.CONTINUE;
        }));
    }
    @Override
    public void tick() {
        super.tick();

        // Отладка текущего состояния
        if (this.getWorld().isClient()) { // Используем getWorld() вместо world
            System.out.println("Entity Position: " + this.getPos());
            // Добавить дополнительную отладку, если потребуется
        }
    }



    @Override
    protected void playStepSound(BlockPos pos, net.minecraft.block.BlockState state) {
        this.playSound(net.minecraft.sound.SoundEvents.ENTITY_WITHER_SKELETON_STEP, 1.0F, 1.0F); // Уникальный звук шагов
    }

    @Override
    protected net.minecraft.sound.SoundEvent getAmbientSound() {
        return net.minecraft.sound.SoundEvents.ENTITY_WITHER_AMBIENT; // Звук в состоянии покоя
    }

    @Override
    protected net.minecraft.sound.SoundEvent getHurtSound(net.minecraft.entity.damage.DamageSource source) {
        return net.minecraft.sound.SoundEvents.ENTITY_WITHER_HURT; // Звук при получении урона
    }

    @Override
    protected net.minecraft.sound.SoundEvent getDeathSound() {
        return net.minecraft.sound.SoundEvents.ENTITY_WITHER_DEATH; // Звук при смерти
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
