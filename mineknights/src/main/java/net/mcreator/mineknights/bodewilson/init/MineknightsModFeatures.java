
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mineknights.bodewilson.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

import net.mcreator.mineknights.bodewilson.world.features.ores.OrigiumOreFeature;
import net.mcreator.mineknights.bodewilson.MineknightsMod;

@Mod.EventBusSubscriber
public class MineknightsModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, MineknightsMod.MODID);
	public static final RegistryObject<Feature<?>> ORIGIUM_ORE = REGISTRY.register("origium_ore", OrigiumOreFeature::feature);
}
