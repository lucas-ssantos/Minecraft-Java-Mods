
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mineknights.bodewilson.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.mineknights.bodewilson.potion.OriopathyMobEffect;
import net.mcreator.mineknights.bodewilson.MineknightsMod;

public class MineknightsModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MineknightsMod.MODID);
	public static final RegistryObject<MobEffect> ORIOPATHY = REGISTRY.register("oriopathy", () -> new OriopathyMobEffect());
}
