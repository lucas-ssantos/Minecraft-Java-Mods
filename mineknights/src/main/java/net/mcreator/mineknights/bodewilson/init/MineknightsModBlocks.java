
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mineknights.bodewilson.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.mineknights.bodewilson.block.ProcessingTableEnergyBlock;
import net.mcreator.mineknights.bodewilson.block.ProcessingTableBlock;
import net.mcreator.mineknights.bodewilson.block.OrigiumOreBlock;
import net.mcreator.mineknights.bodewilson.block.EnergyProjectorBlock;
import net.mcreator.mineknights.bodewilson.block.ArknightsPortalBlock;
import net.mcreator.mineknights.bodewilson.MineknightsMod;

public class MineknightsModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, MineknightsMod.MODID);
	public static final RegistryObject<Block> ORIGIUM_ORE = REGISTRY.register("origium_ore", () -> new OrigiumOreBlock());
	public static final RegistryObject<Block> ARKNIGHTS_PORTAL = REGISTRY.register("arknights_portal", () -> new ArknightsPortalBlock());
	public static final RegistryObject<Block> PROCESSING_TABLE = REGISTRY.register("processing_table", () -> new ProcessingTableBlock());
	public static final RegistryObject<Block> PROCESSING_TABLE_ENERGY = REGISTRY.register("processing_table_energy", () -> new ProcessingTableEnergyBlock());
	public static final RegistryObject<Block> ENERGY_PROJECTOR = REGISTRY.register("energy_projector", () -> new EnergyProjectorBlock());
}
