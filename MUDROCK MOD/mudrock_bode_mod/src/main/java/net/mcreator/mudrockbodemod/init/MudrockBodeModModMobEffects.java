
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mudrockbodemod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.mudrockbodemod.potion.MudrockShieldMobEffect;
import net.mcreator.mudrockbodemod.MudrockBodeModMod;

public class MudrockBodeModModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MudrockBodeModMod.MODID);
	public static final RegistryObject<MobEffect> MUDROCK_SHIELD = REGISTRY.register("mudrock_shield", () -> new MudrockShieldMobEffect());
}
