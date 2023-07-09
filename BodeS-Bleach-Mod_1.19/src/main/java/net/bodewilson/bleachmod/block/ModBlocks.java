package net.bodewilson.bleachmod.block;

import net.bodewilson.bleachmod.BleachMod;
import net.bodewilson.bleachmod.block.custom.ReiryokuTrap;
import net.bodewilson.bleachmod.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block REIRYOKU_ORE = registerBlock("reiryoku_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
            UniformIntProvider.create(3,7)), ModItemGroup.BLEACHMOD);

    public static final Block DEEPSLATE_REIRYOKU_ORE = registerBlock("deepslate_reiryoku_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
            UniformIntProvider.create(4,8)), ModItemGroup.BLEACHMOD);

    public static final Block ENDSTONE_REIRYOKU_ORE = registerBlock("endstone_reiryoku_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                    UniformIntProvider.create(7,10)), ModItemGroup.BLEACHMOD);

    public static final Block NETHERRACK_REIRYOKU_ORE = registerBlock("netherrack_reiryoku_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                    UniformIntProvider.create(5,9)), ModItemGroup.BLEACHMOD);


    public static final Block REIRYOKU_TRAP = registerBlock("reiryoku_trap",
            new ReiryokuTrap(FabricBlockSettings.of(Material.CAKE)), ModItemGroup.BLEACHMOD);


    private static Block registerBlock(String name, Block block, ItemGroup tab)
    {
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(BleachMod.MOD_ID, name), block);
    }
    private static Block registerBlock(String name, Block block)
    {
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(BleachMod.MOD_ID, name), block);
    }


    private static Item registerBlockItem(String name, Block block, ItemGroup tab)
    {
        return Registry.register(Registry.ITEM, new Identifier(BleachMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }
    private static Item registerBlockItem(String name, Block block)
    {
        return Registry.register(Registry.ITEM, new Identifier(BleachMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static  void registerModBlocks()
    {
        BleachMod.LOGGER.debug("Registering ModBlocks for " + BleachMod.MOD_ID);
    }
}
