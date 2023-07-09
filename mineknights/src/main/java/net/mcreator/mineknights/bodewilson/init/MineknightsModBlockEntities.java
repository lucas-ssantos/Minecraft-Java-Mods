
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mineknights.bodewilson.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.mineknights.bodewilson.block.entity.ProcessingTableEnergyBlockEntity;
import net.mcreator.mineknights.bodewilson.block.entity.ProcessingTableBlockEntity;
import net.mcreator.mineknights.bodewilson.block.entity.EnergyProjectorBlockEntity;
import net.mcreator.mineknights.bodewilson.MineknightsMod;

public class MineknightsModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MineknightsMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> PROCESSING_TABLE = register("processing_table", MineknightsModBlocks.PROCESSING_TABLE, ProcessingTableBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> PROCESSING_TABLE_ENERGY = register("processing_table_energy", MineknightsModBlocks.PROCESSING_TABLE_ENERGY, ProcessingTableEnergyBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ENERGY_PROJECTOR = register("energy_projector", MineknightsModBlocks.ENERGY_PROJECTOR, EnergyProjectorBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
