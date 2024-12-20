package com.infinity.tsukuyomi.render;

import com.infinity.tsukuyomi.entity.MadaraEntity;
import com.infinity.tsukuyomi.render.model.MadaraModel;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class MadaraRenderer extends MobEntityRenderer<MadaraEntity, MadaraModel> {

    // Идентификатор текстуры модели
    public static final Identifier MADARA_TEXTURE = new Identifier("infinity_tsukuyomi", "textures/entity/madara.png");

    // Слой модели для Madara
    public static final EntityModelLayer MADARA_LAYER = new EntityModelLayer(
            new Identifier("infinity_tsukuyomi", "madara"),
            "main"
    );

    public MadaraRenderer(EntityRendererFactory.Context context) {
        super(context, new MadaraModel(context.getPart(MADARA_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(MadaraEntity entity) {
        return MADARA_TEXTURE;
    }

    // Регистрация модели для слоя
    public static TexturedModelData createModelData() {
        return MadaraModel.getTexturedModelData();
    }
}
