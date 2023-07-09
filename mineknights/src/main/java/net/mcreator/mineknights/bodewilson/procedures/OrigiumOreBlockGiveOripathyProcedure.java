package net.mcreator.mineknights.bodewilson.procedures;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.Minecraft;

import net.mcreator.mineknights.bodewilson.init.MineknightsModMobEffects;

public class OrigiumOreBlockGiveOripathyProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double chance = 0;
		if ((new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
				} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
				}
				return false;
			}
		}.checkGamemode(entity)) == true) {
			chance = Math.random() * 100;
			if (chance <= 20) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MineknightsModMobEffects.ORIOPATHY.get(), 20000000, 1));
			}
		}
	}
}
