package net.bodewilson.bleachmod.item;

import net.bodewilson.bleachmod.BleachMod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup
{
    public static  final ItemGroup BLEACHMOD = FabricItemGroupBuilder.build(
            new Identifier(BleachMod.MOD_ID, "bleach_mod"), () -> new ItemStack(ModItems.REIRYOKU));
}
