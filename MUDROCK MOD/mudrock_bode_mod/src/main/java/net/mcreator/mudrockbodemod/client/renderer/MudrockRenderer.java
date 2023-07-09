
package net.mcreator.mudrockbodemod.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.mudrockbodemod.entity.MudrockEntity;
import net.mcreator.mudrockbodemod.client.model.Modelcustom_model;

public class MudrockRenderer extends MobRenderer<MudrockEntity, Modelcustom_model<MudrockEntity>> {
	public MudrockRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcustom_model(context.bakeLayer(Modelcustom_model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MudrockEntity entity) {
		return new ResourceLocation("mudrock_bode_mod:textures/entities/mudrock-on-planetminecraft-com.png");
	}
}
