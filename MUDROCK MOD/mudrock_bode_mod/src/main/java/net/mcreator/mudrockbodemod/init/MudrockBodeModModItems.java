
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mudrockbodemod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

import net.mcreator.mudrockbodemod.item.WoodHammerItem;
import net.mcreator.mudrockbodemod.item.WeddingRingItem;
import net.mcreator.mudrockbodemod.item.StoneHammerItem;
import net.mcreator.mudrockbodemod.item.NetheriteHammerItem;
import net.mcreator.mudrockbodemod.item.MudrockHammerItem;
import net.mcreator.mudrockbodemod.item.IronHammerItem;
import net.mcreator.mudrockbodemod.item.GoldenHammerItem;
import net.mcreator.mudrockbodemod.item.EngagementRingItem;
import net.mcreator.mudrockbodemod.item.DiamondHammerItem;
import net.mcreator.mudrockbodemod.item.DatingRingItem;
import net.mcreator.mudrockbodemod.MudrockBodeModMod;

public class MudrockBodeModModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MudrockBodeModMod.MODID);
	public static final RegistryObject<Item> MUDROCK_SPAWN_EGG = REGISTRY.register("mudrock_spawn_egg", () -> new ForgeSpawnEggItem(MudrockBodeModModEntities.MUDROCK, -3355393, -10066330, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> MUDROCK_HAMMER = REGISTRY.register("mudrock_hammer", () -> new MudrockHammerItem());
	public static final RegistryObject<Item> DATING_RING = REGISTRY.register("dating_ring", () -> new DatingRingItem());
	public static final RegistryObject<Item> ENGAGEMENT_RING = REGISTRY.register("engagement_ring", () -> new EngagementRingItem());
	public static final RegistryObject<Item> WEDDING_RING = REGISTRY.register("wedding_ring", () -> new WeddingRingItem());
	public static final RegistryObject<Item> NETHERITE_HAMMER = REGISTRY.register("netherite_hammer", () -> new NetheriteHammerItem());
	public static final RegistryObject<Item> IRON_HAMMER = REGISTRY.register("iron_hammer", () -> new IronHammerItem());
	public static final RegistryObject<Item> DIAMOND_HAMMER = REGISTRY.register("diamond_hammer", () -> new DiamondHammerItem());
	public static final RegistryObject<Item> WOOD_HAMMER = REGISTRY.register("wood_hammer", () -> new WoodHammerItem());
	public static final RegistryObject<Item> STONE_HAMMER = REGISTRY.register("stone_hammer", () -> new StoneHammerItem());
	public static final RegistryObject<Item> GOLDEN_HAMMER = REGISTRY.register("golden_hammer", () -> new GoldenHammerItem());
}
