package net.bodewilson.bleachmod;

import net.bodewilson.bleachmod.entity.client.armor.ShihakushoArmorRenderer;
import net.bodewilson.bleachmod.item.ModItems;
import net.fabricmc.api.ClientModInitializer;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class BleachModClient implements ClientModInitializer
{

    @Override
    public void onInitializeClient() {
        GeoArmorRenderer.registerArmorRenderer(new ShihakushoArmorRenderer(), ModItems.SANDALS,
                ModItems.SHIHAKUSHO_LEGGINGS, ModItems.SHIHAKUSHO_CHESTPLATE);
    }
}
