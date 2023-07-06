package com.apple.library.coregraphics;

import com.apple.library.uikit.UIFont;
import com.mojang.blaze3d.vertex.PoseStack;
import moe.plushie.armourers_workshop.utils.math.Vector3f;
import net.minecraft.client.renderer.MultiBufferSource;

public interface CGGraphicsState {

    PoseStack ctm();

    MultiBufferSource buffers();

    UIFont font();

    float mouseX();

    float mouseY();

    float partialTicks();

    void flush();

    default void save() {
        ctm().pushPose();
    }

    default void translate(float x, float y, float z) {
        if (x != 0 || y != 0 || z != 0) {
            ctm().translate(x, y, z);
        }
    }

    default void rotate(float x, float y, float z) {
        if (x != 0) {
            ctm().mulPose(Vector3f.XP.rotationDegrees(x));
        }
        if (y != 0) {
            ctm().mulPose(Vector3f.YP.rotationDegrees(y));
        }
        if (z != 0) {
            ctm().mulPose(Vector3f.ZP.rotationDegrees(z));
        }
    }

    default void restore() {
        ctm().popPose();
    }
}
