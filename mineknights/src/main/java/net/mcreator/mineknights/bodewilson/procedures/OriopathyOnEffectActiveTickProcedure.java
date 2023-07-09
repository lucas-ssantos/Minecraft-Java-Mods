package net.mcreator.mineknights.bodewilson.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

public class OriopathyOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double time = 0;
		time = time + 1;
		if (time == 240) {
			entity.hurt(DamageSource.WITHER, 1);
		}
	}
}
