
package net.mcreator.mudrockbodemod.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.mudrockbodemod.procedures.MudrockShieldOnEffectActiveTickProcedure;
import net.mcreator.mudrockbodemod.procedures.MudrockShieldEffectExpiresProcedure;

public class MudrockShieldMobEffect extends MobEffect {
	public MudrockShieldMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16777216);
	}

	@Override
	public String getDescriptionId() {
		return "effect.mudrock_bode_mod.mudrock_shield";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		MudrockShieldOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		MudrockShieldEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
