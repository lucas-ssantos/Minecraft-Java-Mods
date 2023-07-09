
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mineknights.bodewilson.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.biome.Biome;

import net.mcreator.mineknights.bodewilson.world.biome.DevastedlandsBiome;
import net.mcreator.mineknights.bodewilson.MineknightsMod;

public class MineknightsModBiomes {
	public static final DeferredRegister<Biome> REGISTRY = DeferredRegister.create(ForgeRegistries.BIOMES, MineknightsMod.MODID);
	public static final RegistryObject<Biome> DEVASTEDLANDS = REGISTRY.register("devastedlands", DevastedlandsBiome::createBiome);
}
