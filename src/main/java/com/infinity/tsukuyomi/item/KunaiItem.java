package com.infinity.tsukuyomi.item;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class KunaiItem extends Item {

    public static final EntityType<KunaiProjectile> KUNAI_PROJECTILE_TYPE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier("infinity_tsukuyomi", "kunai_projectile"),
            FabricEntityTypeBuilder.<KunaiProjectile>create(SpawnGroup.MISC, KunaiProjectile::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // Размеры снаряда
                    .trackRangeBlocks(4)
                    .trackedUpdateRate(10)
                    .build()
    );

    public KunaiItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (!world.isClient) {
            KunaiProjectile kunai = new KunaiProjectile(world, user);
            kunai.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
            world.spawnEntity(kunai);

            if (!user.getAbilities().creativeMode) {
                stack.decrement(1);
            }
        }

        return TypedActionResult.success(stack, world.isClient());
    }

    public static void register() {
        // Регистрация предмета
        Registry.register(Registries.ITEM, new Identifier("infinity_tsukuyomi", "kunai"), new KunaiItem(new Settings().maxCount(16)));

        // Регистрация рендера
        EntityRendererRegistry.register(KUNAI_PROJECTILE_TYPE, FlyingItemEntityRenderer::new);
    }

    public static class KunaiProjectile extends PersistentProjectileEntity implements net.minecraft.entity.FlyingItemEntity {

        public KunaiProjectile(World world, LivingEntity owner) {
            super(KUNAI_PROJECTILE_TYPE, owner, world);
        }

        public KunaiProjectile(EntityType<? extends PersistentProjectileEntity> type, World world) {
            super(type, world);
        }

        @Override
        protected void onEntityHit(EntityHitResult entityHitResult) {
            Entity target = entityHitResult.getEntity();
            DamageSource damageSource = this.getWorld().getDamageSources().thrown(this, this.getOwner());
            target.damage(damageSource, 5.0F);
            this.discard();
        }

        @Override
        public ItemStack asItemStack() {
            return new ItemStack(ModItems.KUNAI);
        }

        @Override
        public ItemStack getStack() {
            return new ItemStack(ModItems.KUNAI);
        }
    }
}
