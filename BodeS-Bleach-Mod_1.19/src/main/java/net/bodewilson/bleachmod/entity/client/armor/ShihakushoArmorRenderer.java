package net.bodewilson.bleachmod.entity.client.armor;

import net.bodewilson.bleachmod.item.custom.ShihakushoArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class ShihakushoArmorRenderer extends GeoArmorRenderer<ShihakushoArmorItem>
{

    public ShihakushoArmorRenderer() {
        super(new ShihakushoArmorModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorRightLeg";
        this.leftLegBone = "armorLeftLeg";
        this.rightBootBone = "armorRightBoot";
        this.leftBootBone = "armorLeftBoot";
    }
}
