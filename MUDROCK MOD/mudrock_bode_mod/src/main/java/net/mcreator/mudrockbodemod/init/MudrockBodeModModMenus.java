
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mudrockbodemod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.mudrockbodemod.world.inventory.WaifuInventoryMenu;
import net.mcreator.mudrockbodemod.MudrockBodeModMod;

public class MudrockBodeModModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, MudrockBodeModMod.MODID);
	public static final RegistryObject<MenuType<WaifuInventoryMenu>> WAIFU_INVENTORY = REGISTRY.register("waifu_inventory", () -> IForgeMenuType.create(WaifuInventoryMenu::new));
}
