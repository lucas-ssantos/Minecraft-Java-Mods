package net.mcreator.mudrockbodemod.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.mudrockbodemod.network.MudrockBodeModModVariables;

public class WaifuAffectionGUIValorProcedure {
	public static String execute(LevelAccessor world) {
		return "Affection: " + MudrockBodeModModVariables.MapVariables.get(world).waifuAffection;
	}
}
