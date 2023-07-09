package net.mcreator.mudrockbodemod.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.mudrockbodemod.init.MudrockBodeModModMobEffects;

public class MudrockEntityIsHurtProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.ANGRY_VILLAGER, x, y, z, 5, 3, 3, 3, 1);
		if (!entity.getPersistentData().getBoolean("ArtsShield")) {
			entity.getPersistentData().putBoolean("ArtsShield", (true));
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MudrockBodeModModMobEffects.MUDROCK_SHIELD.get(), 1200, 1));
		} else {
			entity.getPersistentData().putBoolean("ArtsShield", (false));
		}
		if (sourceentity == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)) {
			if (!world.isClientSide()) {
				MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
				if (_mcserv != null)
					_mcserv.getPlayerList().broadcastSystemMessage(Component.literal((entity.getPersistentData().getString("waifuName") + ": " + "That hurt :c")), false);
			}
		} else {
			if (entity instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
				_entity.setTarget(_ent);
		}
	}
}
