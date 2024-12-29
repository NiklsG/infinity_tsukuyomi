package com.infinity.tsukuyomi.client.renderer;

import com.infinity.tsukuyomi.client.renderer.model.MadaraModel;
import com.infinity.tsukuyomi.entity.MadaraEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MadaraRenderer extends GeoEntityRenderer<MadaraEntity> {

    public MadaraRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MadaraModel());
    }

    @Override
    public Identifier getTextureLocation(MadaraEntity animatable) {
        // Указываем путь к текстуре сущности
        return new Identifier("infinity_tsukuyomi", "textures/entity/madara.png");
    }
}
