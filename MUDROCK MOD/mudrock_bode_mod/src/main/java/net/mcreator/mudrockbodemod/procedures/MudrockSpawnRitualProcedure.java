package net.mcreator.mudrockbodemod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.level.BlockEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.mudrockbodemod.init.MudrockBodeModModEntities;
import net.mcreator.mudrockbodemod.entity.MudrockEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class MudrockSpawnRitualProcedure {
	@SubscribeEvent
	public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(new BlockPos(x + 0, y - 1, z + 0))).getBlock() == Blocks.NETHERITE_BLOCK && (world.getBlockState(new BlockPos(x + 1, y - 1, z + 0))).getBlock() == Blocks.POLISHED_DEEPSLATE
				&& (world.getBlockState(new BlockPos(x - 1, y - 1, z + 0))).getBlock() == Blocks.POLISHED_DEEPSLATE && (world.getBlockState(new BlockPos(x + 0, y - 1, z - 1))).getBlock() == Blocks.POLISHED_DEEPSLATE
				&& (world.getBlockState(new BlockPos(x + 0, y - 1, z + 1))).getBlock() == Blocks.POLISHED_DEEPSLATE && (world.getBlockState(new BlockPos(x + 1, y - 1, z - 1))).getBlock() == Blocks.MUD
				&& (world.getBlockState(new BlockPos(x - 1, y - 1, z - 1))).getBlock() == Blocks.MUD && (world.getBlockState(new BlockPos(x + 1, y - 1, z + 1))).getBlock() == Blocks.MUD
				&& (world.getBlockState(new BlockPos(x - 1, y - 1, z + 1))).getBlock() == Blocks.MUD && (world.getBlockState(new BlockPos(x + 0, y - 1, z - 2))).getBlock() == Blocks.ANDESITE
				&& (world.getBlockState(new BlockPos(x + 2, y - 1, z + 0))).getBlock() == Blocks.ANDESITE && (world.getBlockState(new BlockPos(x - 2, y - 1, z + 0))).getBlock() == Blocks.ANDESITE
				&& (world.getBlockState(new BlockPos(x - 0, y - 1, z - 2))).getBlock() == Blocks.ANDESITE && (world.getBlockState(new BlockPos(x + 1, y - 1, z - 2))).getBlock() == Blocks.SOUL_SAND
				&& (world.getBlockState(new BlockPos(x - 2, y - 1, z + 1))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(new BlockPos(x - 1, y - 1, z + 2))).getBlock() == Blocks.SOUL_SAND
				&& (world.getBlockState(new BlockPos(x - 2, y - 1, z - 1))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(new BlockPos(x - 1, y - 1, z - 2))).getBlock() == Blocks.SOUL_SAND
				&& (world.getBlockState(new BlockPos(x + 2, y - 1, z - 1))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(new BlockPos(x + 1, y - 1, z + 2))).getBlock() == Blocks.SOUL_SAND
				&& (world.getBlockState(new BlockPos(x + 2, y - 1, z + 1))).getBlock() == Blocks.SOUL_SAND && (world.getBlockState(new BlockPos(x - 2, y - 1, z - 2))).getBlock() == Blocks.POLISHED_DEEPSLATE
				&& (world.getBlockState(new BlockPos(x + 2, y - 1, z + 2))).getBlock() == Blocks.POLISHED_DEEPSLATE && (world.getBlockState(new BlockPos(x - 2, y - 1, z + 2))).getBlock() == Blocks.POLISHED_DEEPSLATE
				&& (world.getBlockState(new BlockPos(x + 2, y - 1, z - 2))).getBlock() == Blocks.POLISHED_DEEPSLATE && (world.getBlockState(new BlockPos(x - 2, y + 0, z - 2))).getBlock() == Blocks.POLISHED_DEEPSLATE
				&& (world.getBlockState(new BlockPos(x - 2, y + 0, z + 2))).getBlock() == Blocks.POLISHED_DEEPSLATE && (world.getBlockState(new BlockPos(x + 2, y + 0, z - 2))).getBlock() == Blocks.POLISHED_DEEPSLATE
				&& (world.getBlockState(new BlockPos(x + 2, y + 0, z + 2))).getBlock() == Blocks.POLISHED_DEEPSLATE && (world.getBlockState(new BlockPos(x - 2, y + 1, z + 2))).getBlock() == Blocks.NETHERITE_BLOCK
				&& (world.getBlockState(new BlockPos(x - 2, y + 1, z - 2))).getBlock() == Blocks.NETHERITE_BLOCK && (world.getBlockState(new BlockPos(x + 2, y + 1, z - 2))).getBlock() == Blocks.NETHERITE_BLOCK
				&& (world.getBlockState(new BlockPos(x + 2, y + 1, z + 2))).getBlock() == Blocks.NETHERITE_BLOCK && (world.getBlockState(new BlockPos(x + 0, y + 0, z + 0))).getBlock() == Blocks.FIRE) {
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
			world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new MudrockEntity(MudrockBodeModModEntities.MUDROCK.get(), _level);
				entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
		}
	}
}
