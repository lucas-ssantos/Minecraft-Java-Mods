
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mineknights.bodewilson.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.mineknights.bodewilson.item.OrigiumShardItem;
import net.mcreator.mineknights.bodewilson.item.OrigiumItem;
import net.mcreator.mineknights.bodewilson.item.OrigiumHealingWandItem;
import net.mcreator.mineknights.bodewilson.item.ArknightsItem;
import net.mcreator.mineknights.bodewilson.MineknightsMod;

public class MineknightsModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MineknightsMod.MODID);
	public static final RegistryObject<Item> ORIGIUM_SHARD = REGISTRY.register("origium_shard", () -> new OrigiumShardItem());
	public static final RegistryObject<Item> ORIGIUM = REGISTRY.register("origium", () -> new OrigiumItem());
	public static final RegistryObject<Item> ORIGIUM_ORE = block(MineknightsModBlocks.ORIGIUM_ORE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> ARKNIGHTS = REGISTRY.register("arknights", () -> new ArknightsItem());
	public static final RegistryObject<Item> PROCESSING_TABLE = block(MineknightsModBlocks.PROCESSING_TABLE, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> PROCESSING_TABLE_ENERGY = block(MineknightsModBlocks.PROCESSING_TABLE_ENERGY, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> ENERGY_PROJECTOR = block(MineknightsModBlocks.ENERGY_PROJECTOR, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> ORIGIUM_HEALING_WAND = REGISTRY.register("origium_healing_wand", () -> new OrigiumHealingWandItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
