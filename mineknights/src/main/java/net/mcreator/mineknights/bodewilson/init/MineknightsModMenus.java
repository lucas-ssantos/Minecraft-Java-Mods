
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mineknights.bodewilson.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.mineknights.bodewilson.world.inventory.ProcessingTableGUIMenu;
import net.mcreator.mineknights.bodewilson.world.inventory.EnergyProjectorGUIMenu;
import net.mcreator.mineknights.bodewilson.MineknightsMod;

public class MineknightsModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, MineknightsMod.MODID);
	public static final RegistryObject<MenuType<ProcessingTableGUIMenu>> PROCESSING_TABLE_GUI = REGISTRY.register("processing_table_gui", () -> IForgeMenuType.create(ProcessingTableGUIMenu::new));
	public static final RegistryObject<MenuType<EnergyProjectorGUIMenu>> ENERGY_PROJECTOR_GUI = REGISTRY.register("energy_projector_gui", () -> IForgeMenuType.create(EnergyProjectorGUIMenu::new));
}
