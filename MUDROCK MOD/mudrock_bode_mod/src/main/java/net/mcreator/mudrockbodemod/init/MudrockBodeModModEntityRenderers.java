
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mudrockbodemod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.mudrockbodemod.client.renderer.MudrockRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MudrockBodeModModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(MudrockBodeModModEntities.MUDROCK.get(), MudrockRenderer::new);
	}
}
