package com.infinity.tsukuyomi.client.renderer.model;

import com.infinity.tsukuyomi.entity.MadaraEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class MadaraModel extends DefaultedEntityGeoModel<MadaraEntity> {

    public MadaraModel() {
        // Привязываем модель по идентификатору
        super(new Identifier("infinity_tsukuyomi", "madara"), true);
    }
}
