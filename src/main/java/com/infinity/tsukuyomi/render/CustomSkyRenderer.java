package com.infinity.tsukuyomi.render;

import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3d;

public class CustomSkyRenderer {

    public static void renderRedSky(MatrixStack matrixStack, float tickDelta, WorldRenderer worldRenderer) {
        // Render Red Sky
        Vec3d redSkyColor = new Vec3d(0.6, 0.1, 0.1);
        System.out.println("Rendering custom red sky with color: " + redSkyColor);
    }
}
