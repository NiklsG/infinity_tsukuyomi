package com.infinity.tsukuyomi.render.model;

import com.infinity.tsukuyomi.entity.MadaraEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class MadaraModel extends EntityModel<MadaraEntity> {
	private final ModelPart Head;
	private final ModelPart Body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;

	public MadaraModel(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Body = root.getChild("Body");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
		this.RightLeg = root.getChild("RightLeg");
		this.LeftLeg = root.getChild("LeftLeg");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		modelPartData.addChild("Head", ModelPartBuilder.create()
						.uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
						.uv(32, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.5F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.1047F, 0.0873F, 0.0F));

		modelPartData.addChild("Body", ModelPartBuilder.create()
						.uv(16, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F))
						.uv(16, 32).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.25F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		modelPartData.addChild("RightArm", ModelPartBuilder.create()
						.uv(40, 16).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F))
						.uv(40, 32).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.25F)), ModelTransform.of(-5.0F, 2.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		modelPartData.addChild("LeftArm", ModelPartBuilder.create()
						.uv(32, 48).cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F))
						.uv(48, 48).cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.25F)), ModelTransform.of(5.0F, 2.0F, 0.0F, 0.2094F, 0.0F, 0.0F));

		modelPartData.addChild("RightLeg", ModelPartBuilder.create()
						.uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F))
						.uv(0, 32).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.25F)), ModelTransform.of(-1.9F, 12.0F, 0.0F, 0.192F, 0.0F, 0.0349F));

		modelPartData.addChild("LeftLeg", ModelPartBuilder.create()
						.uv(16, 48).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F))
						.uv(0, 48).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.25F)), ModelTransform.of(1.9F, 12.0F, 0.0F, -0.1745F, 0.0F, -0.0349F));

		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(com.infinity.tsukuyomi.entity.MadaraEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		Head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		Body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		RightArm.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		LeftArm.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		RightLeg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		LeftLeg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}
