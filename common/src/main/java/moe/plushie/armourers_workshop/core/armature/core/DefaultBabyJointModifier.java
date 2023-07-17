package moe.plushie.armourers_workshop.core.armature.core;

import moe.plushie.armourers_workshop.api.client.IJoint;
import moe.plushie.armourers_workshop.api.client.model.IModel;
import moe.plushie.armourers_workshop.api.math.ITransformf;
import moe.plushie.armourers_workshop.api.math.IVector3f;
import moe.plushie.armourers_workshop.core.armature.ArmatureModifier;

public class DefaultBabyJointModifier extends ArmatureModifier {

    @Override
    public ITransformf apply(IJoint joint, IModel model, ITransformf transform) {
        return poseStack -> {
            transform.apply(poseStack);
            if (!model.isBaby()) {
                return;
            }
            float scale = model.getBabyScale();
            IVector3f offset = model.getBabyOffset();
            if (offset == null) {
                return;
            }
            poseStack.scale(scale, scale, scale);
            poseStack.translate(offset.getX() / 16f, offset.getY() / 16f, offset.getZ() / 16f);
        };
    }
}
