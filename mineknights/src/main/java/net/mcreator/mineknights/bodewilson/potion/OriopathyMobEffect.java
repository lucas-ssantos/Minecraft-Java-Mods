
package net.mcreator.mineknights.bodewilson.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.mineknights.bodewilson.procedures.OriopathyOnEffectActiveTickProcedure;

public class OriopathyMobEffect extends MobEffect {
	public OriopathyMobEffect() {
		super(MobEffectCategory.HARMFUL, -8187631);
	}

	@Override
	public String getDescriptionId() {
		return "effect.mineknights.oriopathy";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		OriopathyOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
