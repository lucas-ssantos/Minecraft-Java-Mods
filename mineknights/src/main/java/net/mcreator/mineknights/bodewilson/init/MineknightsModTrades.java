
/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.mcreator.mineknights.bodewilson.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MineknightsModTrades {
	@SubscribeEvent
	public static void registerWanderingTrades(WandererTradesEvent event) {
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.FLINT_AND_STEEL),

				new ItemStack(MineknightsModItems.ARKNIGHTS.get()), 10, 5, 0.05f));
	}
}
