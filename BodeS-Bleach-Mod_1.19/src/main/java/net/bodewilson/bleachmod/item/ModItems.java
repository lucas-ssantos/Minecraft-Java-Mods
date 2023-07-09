package net.bodewilson.bleachmod.item;

import net.bodewilson.bleachmod.BleachMod;
import net.bodewilson.bleachmod.item.custom.ModArmorItem;
import net.bodewilson.bleachmod.item.custom.ShihakushoArmorItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems
{
    public static final Item REIRYOKU = registerItem("reiryoku",
            new Item(new FabricItemSettings().group(ModItemGroup.BLEACHMOD)));
    public static final Item REIATSU_INGOT = registerItem("reiatsu_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.BLEACHMOD)));

    public static final Item ZANPAKTO = registerItem("zanpakto",
            new SwordItem(ModToolMaterials.REIATSU, 6, 2F,
                    new FabricItemSettings().group(ModItemGroup.BLEACHMOD)));

    public static final Item SHIHAKUSHO_CHESTPLATE = registerItem("shihakusho_chestplate",
            new ShihakushoArmorItem(ModArmorMaterials.REIATSU, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.BLEACHMOD)));
    public static final Item SHIHAKUSHO_LEGGINGS = registerItem("shihakusho_leggings",
            new ShihakushoArmorItem(ModArmorMaterials.REIATSU, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroup.BLEACHMOD)));
    public static final Item SANDALS = registerItem("sandals",
            new ShihakushoArmorItem(ModArmorMaterials.REIATSU, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.BLEACHMOD)));


    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registry.ITEM, new Identifier(BleachMod.MOD_ID, name), item);
    }

    public static  void registerModItems()
    {
        BleachMod.LOGGER.debug("Registering Mod Items for " + BleachMod.MOD_ID);
    }
}
