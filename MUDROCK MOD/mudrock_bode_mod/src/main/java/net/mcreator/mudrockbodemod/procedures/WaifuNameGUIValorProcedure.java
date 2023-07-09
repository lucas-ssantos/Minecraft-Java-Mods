package net.mcreator.mudrockbodemod.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.mudrockbodemod.network.MudrockBodeModModVariables;

public class WaifuNameGUIValorProcedure {
	public static String execute(LevelAccessor world) {
		return MudrockBodeModModVariables.MapVariables.get(world).waifuName;
	}
}
