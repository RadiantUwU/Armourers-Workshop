package moe.plushie.armourers_workshop.core.client.skinrender;

import moe.plushie.armourers_workshop.api.client.model.IModel;
import moe.plushie.armourers_workshop.api.math.IPoseStack;
import moe.plushie.armourers_workshop.core.client.other.SkinOverriddenManager;
import moe.plushie.armourers_workshop.core.client.other.SkinRenderData;
import moe.plushie.armourers_workshop.core.entity.EntityProfile;
import moe.plushie.armourers_workshop.core.skin.part.SkinPartTypes;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.world.entity.monster.Ghast;

@Environment(EnvType.CLIENT)
public class GhastSkinRenderer<T extends Ghast, M extends IModel> extends LivingSkinRenderer<T, M> {

    public GhastSkinRenderer(EntityProfile profile) {
        super(profile);
    }

    @Override
    public void initTransformers() {
        transformer.registerArmor(SkinPartTypes.BIPPED_HEAD, this::offset);
    }

    @Override
    protected void apply(T entity, M model, SkinOverriddenManager overriddenManager, SkinRenderData renderData) {
        super.apply(entity, model, overriddenManager, renderData);
        if (overriddenManager.overrideModel(SkinPartTypes.BIPPED_HEAD)) {
            model.getAllParts().forEach(this::addModelOverride);
        }
    }

    private void offset(IPoseStack poseStack, M model) {
        poseStack.translate(0.0f, 24.0f + 1.5f, 0.0f);
        poseStack.scale(2f, 2f, 2f);
    }
}
