package net.bodewilson.bleachmod.entity.client.armor;

import net.bodewilson.bleachmod.BleachMod;
import net.bodewilson.bleachmod.item.custom.ShihakushoArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ShihakushoArmorModel extends AnimatedGeoModel<ShihakushoArmorItem>
{

    @Override
    public Identifier getModelResource(ShihakushoArmorItem object) {
        return new Identifier(BleachMod.MOD_ID, "geo/shihakusho_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(ShihakushoArmorItem object) {
        return new Identifier(BleachMod.MOD_ID, "textures/models/armor/shihakusho_armor_texture.png");
    }

    @Override
    public Identifier getAnimationResource(ShihakushoArmorItem animatable) {
        return new Identifier(BleachMod.MOD_ID, "animations/shihakusho_armor.json");
    }
}
