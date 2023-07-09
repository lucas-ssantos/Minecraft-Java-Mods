
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mineknights.bodewilson.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.mineknights.bodewilson.client.gui.ProcessingTableGUIScreen;
import net.mcreator.mineknights.bodewilson.client.gui.EnergyProjectorGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MineknightsModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(MineknightsModMenus.PROCESSING_TABLE_GUI.get(), ProcessingTableGUIScreen::new);
			MenuScreens.register(MineknightsModMenus.ENERGY_PROJECTOR_GUI.get(), EnergyProjectorGUIScreen::new);
		});
	}
}
