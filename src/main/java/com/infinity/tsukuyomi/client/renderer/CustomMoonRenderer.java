package com.infinity.tsukuyomi.client.renderer;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.joml.Matrix4f;

public class CustomMoonRenderer {

    private static final Identifier RED_MOON_TEXTURE = new Identifier("infinity_tsukuyomi", "textures/environment/red_moon.png");

    public static void render(MatrixStack matrices) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderTexture(0, RED_MOON_TEXTURE);

        float size = 40.0F;
        float depth = -100.0F;

        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer = tessellator.getBuffer();

        Matrix4f positionMatrix = matrices.peek().getPositionMatrix();

        buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
        buffer.vertex(positionMatrix, -size, depth, size).texture(0.0F, 0.0F).next();
        buffer.vertex(positionMatrix, size, depth, size).texture(1.0F, 0.0F).next();
        buffer.vertex(positionMatrix, size, depth, -size).texture(1.0F, 1.0F).next();
        buffer.vertex(positionMatrix, -size, depth, -size).texture(0.0F, 1.0F).next();
        tessellator.draw();
    }
}
