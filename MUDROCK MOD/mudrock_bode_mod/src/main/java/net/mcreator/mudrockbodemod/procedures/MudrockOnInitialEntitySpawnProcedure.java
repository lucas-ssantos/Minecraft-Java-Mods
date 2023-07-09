package net.mcreator.mudrockbodemod.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import java.util.Iterator;

public class MudrockOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayer _player) {
			Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("mudrock_bode_mod:spawn_mudrock"));
			AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
			if (!_ap.isDone()) {
				Iterator _iterator = _ap.getRemainingCriteria().iterator();
				while (_iterator.hasNext())
					_player.getAdvancements().award(_adv, (String) _iterator.next());
			}
		}
		entity.getPersistentData().putString("waifuName", "Mudrock");
		entity.getPersistentData().putDouble("affection", 0);
		entity.getPersistentData().putBoolean("isAcquintance", (true));
		entity.getPersistentData().putBoolean("isFriend", (false));
		entity.getPersistentData().putBoolean("isBestFriend", (false));
		entity.getPersistentData().putBoolean("isDating", (false));
		entity.getPersistentData().putBoolean("isEngaged", (false));
		entity.getPersistentData().putBoolean("isMarried", (false));
		entity.getPersistentData().putBoolean("ArtsShield", (false));
		if (!world.isClientSide()) {
			MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
			if (_mcserv != null)
				_mcserv.getPlayerList().broadcastSystemMessage(Component.literal((entity.getPersistentData().getString("waifuName") + ": " + "Are you the doctor?")), false);
		}
	}
}
