package com.infinity.tsukuyomi.entity;

import com.infinity.tsukuyomi.InfinityTsukuyomi;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<MadaraEntity> MADARA = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(InfinityTsukuyomi.MOD_ID, "madara"),
            FabricEntityTypeBuilder.createMob()
                    .entityFactory(MadaraEntity::new)
                    .defaultAttributes(MadaraEntity::createMadaraAttributes)
                    .spawnGroup(SpawnGroup.MONSTER)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.8f)) // Размеры сущности
                    .trackRangeBlocks(8)
                    .build()
    );

    public static void registerEntities() {
        FabricDefaultAttributeRegistry.register(MADARA, MadaraEntity.createMadaraAttributes());
    }
}
