package net.mcreator.mudrockbodemod.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.MinecraftServer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.mudrockbodemod.world.inventory.WaifuInventoryMenu;
import net.mcreator.mudrockbodemod.network.MudrockBodeModModVariables;
import net.mcreator.mudrockbodemod.init.MudrockBodeModModItems;

import java.util.Iterator;

import io.netty.buffer.Unpooled;

public class MudrockRightClickedOnEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity.getPersistentData().getDouble("timer") == 0) {
			entity.getPersistentData().putDouble("timer", 1);
		} else {
			entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") - 1));
		}
		if (entity.getPersistentData().getDouble("timer") == 0) {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == (ItemStack.EMPTY).getItem()) {
				if (sourceentity.isShiftKeyDown() && (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false)) {
					MudrockBodeModModVariables.MapVariables.get(world).waifuName = entity.getPersistentData().getString("waifuName");
					MudrockBodeModModVariables.MapVariables.get(world).syncData(world);
					MudrockBodeModModVariables.MapVariables.get(world).waifuAffection = entity.getPersistentData().getDouble("affection");
					MudrockBodeModModVariables.MapVariables.get(world).syncData(world);
					if (entity.getPersistentData().getBoolean("isMarried")) {
						MudrockBodeModModVariables.MapVariables.get(world).waifuRelationship = "Relationship: Married";
						MudrockBodeModModVariables.MapVariables.get(world).syncData(world);
						{
							if (sourceentity instanceof ServerPlayer _ent) {
								BlockPos _bpos = new BlockPos(x, y, z);
								NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
									@Override
									public Component getDisplayName() {
										return Component.literal("WaifuInventory");
									}

									@Override
									public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
										return new WaifuInventoryMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
									}
								}, _bpos);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.HEART, x, y, z, 3, 3, 3, 3, 1);
					} else if (entity.getPersistentData().getBoolean("isEngaged")) {
						MudrockBodeModModVariables.MapVariables.get(world).waifuRelationship = "Relationship: Engaged";
						MudrockBodeModModVariables.MapVariables.get(world).syncData(world);
						{
							if (sourceentity instanceof ServerPlayer _ent) {
								BlockPos _bpos = new BlockPos(x, y, z);
								NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
									@Override
									public Component getDisplayName() {
										return Component.literal("WaifuInventory");
									}

									@Override
									public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
										return new WaifuInventoryMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
									}
								}, _bpos);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.HEART, x, y, z, 3, 3, 3, 3, 1);
					} else if (entity.getPersistentData().getBoolean("isDating")) {
						MudrockBodeModModVariables.MapVariables.get(world).waifuRelationship = "Relationship: Dating";
						MudrockBodeModModVariables.MapVariables.get(world).syncData(world);
						{
							if (sourceentity instanceof ServerPlayer _ent) {
								BlockPos _bpos = new BlockPos(x, y, z);
								NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
									@Override
									public Component getDisplayName() {
										return Component.literal("WaifuInventory");
									}

									@Override
									public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
										return new WaifuInventoryMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
									}
								}, _bpos);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.HEART, x, y, z, 3, 3, 3, 3, 1);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 2, 3, 3, 3, 1);
				if (!world.isClientSide()) {
					MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
					if (_mcserv != null)
						_mcserv.getPlayerList().broadcastSystemMessage(Component.literal((entity.getPersistentData().getString("waifuName") + ": " + "Thanks.")), false);
				}
			} else {
				if (sourceentity.isShiftKeyDown()) {
					if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.STONE.asItem()
							|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.MUD.asItem()) {
						if (!(entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && entity.getPersistentData().getDouble("affection") <= 15) {
							entity.getPersistentData().putDouble("affection", (entity.getPersistentData().getDouble("affection") + 1));
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 2, 3, 3, 3, 1);
							if (!world.isClientSide()) {
								MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
								if (_mcserv != null)
									_mcserv.getPlayerList().broadcastSystemMessage(Component.literal((entity.getPersistentData().getString("waifuName") + ": " + "Oh... I was not expecting this... But thank you.")), false);
							}
						} else if (!(entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && entity.getPersistentData().getDouble("affection") <= 30) {
							entity.getPersistentData().putBoolean("isFriend", (true));
							entity.getPersistentData().putDouble("affection", (entity.getPersistentData().getDouble("affection") + 1));
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 2, 3, 3, 3, 1);
							if (!world.isClientSide()) {
								MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
								if (_mcserv != null)
									_mcserv.getPlayerList().broadcastSystemMessage(Component.literal((entity.getPersistentData().getString("waifuName") + ": " + "Oh... I was not expecting this... But thank you.")), false);
							}
						} else if (!(entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && entity.getPersistentData().getDouble("affection") <= 50) {
							entity.getPersistentData().putBoolean("isBestFriend", (true));
							entity.getPersistentData().putDouble("affection", (entity.getPersistentData().getDouble("affection") + 1));
							if (!world.isClientSide()) {
								MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
								if (_mcserv != null)
									_mcserv.getPlayerList().broadcastSystemMessage(Component.literal((entity.getPersistentData().getString("waifuName") + ": " + "Oh... I was not expecting this... But thank you.")), false);
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 2, 3, 3, 3, 1);
						} else if (entity.getPersistentData().getBoolean("isDating") && entity.getPersistentData().getDouble("affection") <= 90) {
							entity.getPersistentData().putDouble("affection", (entity.getPersistentData().getDouble("affection") + 1));
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 5, 3, 3, 3, 1);
							if (!world.isClientSide()) {
								MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
								if (_mcserv != null)
									_mcserv.getPlayerList().broadcastSystemMessage(Component.literal((entity.getPersistentData().getString("waifuName") + ": " + "Thank you. Look at this beatiful gift friends!")), false);
							}
							if (!world.isClientSide()) {
								MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
								if (_mcserv != null)
									_mcserv.getPlayerList().broadcastSystemMessage(Component.literal((entity.getPersistentData().getString("waifuName") + ": " + "Oh sorry... I got a little carried away...")), false);
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.ASH, x, y, z, 2, 3, 3, 3, 1);
							if (!world.isClientSide()) {
								MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
								if (_mcserv != null)
									_mcserv.getPlayerList().broadcastSystemMessage(Component.literal((entity.getPersistentData().getString("waifuName") + ": " + "I was talking to the my rocky firends...")), false);
							}
						} else if (entity.getPersistentData().getBoolean("isEngage") && entity.getPersistentData().getDouble("affection") <= 180) {
							entity.getPersistentData().putDouble("affection", (entity.getPersistentData().getDouble("affection") + 1));
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.HEART, x, y, z, 3, 3, 3, 3, 1);
							if (!world.isClientSide()) {
								MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
								if (_mcserv != null)
									_mcserv.getPlayerList().broadcastSystemMessage(Component.literal((entity.getPersistentData().getString("waifuName") + ": " + "Thank you! I will cherish it.")), false);
							}
						} else if (entity.getPersistentData().getBoolean("isMarried")) {
							entity.getPersistentData().putDouble("affection", (entity.getPersistentData().getDouble("affection") + 1));
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.HEART, x, y, z, 5, 3, 3, 3, 1);
							if (!world.isClientSide()) {
								MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
								if (_mcserv != null)
									_mcserv.getPlayerList().broadcastSystemMessage(Component.literal((entity.getPersistentData().getString("waifuName") + ": " + "Thank you!")), false);
							}
							if (!world.isClientSide()) {
								MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
								if (_mcserv != null)
									_mcserv.getPlayerList().broadcastSystemMessage(Component.literal((entity.getPersistentData().getString("waifuName") + ": " + "But you know... You don't have to give me gifts to make me happy!")), false);
							}
						} else {
							if (!world.isClientSide()) {
								MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
								if (_mcserv != null)
									_mcserv.getPlayerList().broadcastSystemMessage(Component.literal((entity.getPersistentData().getString("waifuName") + ": " + "Thanks.")), false);
							}
						}
						if (sourceentity instanceof Player _player) {
							ItemStack _stktoremove = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.SKELETON_SKULL.asItem()
							|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.WITHER_SKELETON_SKULL.asItem()
							|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.ZOMBIE_HEAD.asItem()) {
						if (!(entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && entity.getPersistentData().getDouble("affection") <= 10) {
							entity.getPersistentData().putDouble("affection", (entity.getPersistentData().getDouble("affection") - 4));
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.ANGRY_VILLAGER, x, y, z, 5, 3, 3, 3, 1);
							if (!world.isClientSide()) {
								MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
								if (_mcserv != null)
									_mcserv.getPlayerList().broadcastSystemMessage(Component.literal((entity.getPersistentData().getString("waifuName") + "BONK!")), false);
							}
							sourceentity.hurt(DamageSource.GENERIC, 4);
						} else if (entity.getPersistentData().getBoolean("isDating")) {
							entity.getPersistentData().putDouble("affection", (entity.getPersistentData().getDouble("affection") - 2));
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.ANGRY_VILLAGER, x, y, z, 5, 3, 3, 3, 1);
							if (!world.isClientSide()) {
								MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
								if (_mcserv != null)
									_mcserv.getPlayerList().broadcastSystemMessage(Component.literal((entity.getPersistentData().getString("waifuName") + "BONK!")), false);
							}
							sourceentity.hurt(DamageSource.GENERIC, 1);
						} else if (entity.getPersistentData().getBoolean("isEngage")) {
							entity.getPersistentData().putDouble("affection", (entity.getPersistentData().getDouble("affection") - 2));
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.ANGRY_VILLAGER, x, y, z, 5, 3, 3, 3, 1);
							if (!world.isClientSide()) {
								MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
								if (_mcserv != null)
									_mcserv.getPlayerList().broadcastSystemMessage(Component.literal((entity.getPersistentData().getString("waifuName") + ": " + "Hum... You know that I don't like those things... Right?")), false);
							}
						} else if (entity.getPersistentData().getBoolean("isMarried")) {
							entity.getPersistentData().putDouble("affection", (entity.getPersistentData().getDouble("affection") - 3));
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.ANGRY_VILLAGER, x, y, z, 5, 3, 3, 3, 1);
							if (!world.isClientSide()) {
								MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
								if (_mcserv != null)
									_mcserv.getPlayerList().broadcastSystemMessage(Component.literal((entity.getPersistentData().getString("waifuName") + ": " + "Hum... Thank you...")), false);
							}
						}
					} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MudrockBodeModModItems.DATING_RING.get()) {
						if (!(entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && entity.getPersistentData().getDouble("affection") >= 9) {
							entity.getPersistentData().putBoolean("isDating", (true));
							if (entity instanceof TamableAnimal _toTame && sourceentity instanceof Player _owner)
								_toTame.tame(_owner);
							if (sourceentity instanceof ServerPlayer _player) {
								Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("mudrock_bode_mod:date_mudrock"));
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									Iterator _iterator = _ap.getRemainingCriteria().iterator();
									while (_iterator.hasNext())
										_player.getAdvancements().award(_adv, (String) _iterator.next());
								}
							}
							if (sourceentity instanceof Player _player) {
								ItemStack _stktoremove = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 5, 3, 3, 3, 1);
							if (!world.isClientSide()) {
								MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
								if (_mcserv != null)
									_mcserv.getPlayerList().broadcastSystemMessage(Component.literal((entity.getPersistentData().getString("waifuName") + ": " + "Oh! I... I think I will accept your proposal...")), false);
							}
						} else {
							if (!world.isClientSide()) {
								MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
								if (_mcserv != null)
									_mcserv.getPlayerList().broadcastSystemMessage(Component.literal((entity.getPersistentData().getString("waifuName") + ": " + "Sorry... But I have to decline.")), false);
							}
						}
					} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MudrockBodeModModItems.ENGAGEMENT_RING.get()) {
						if (entity.getPersistentData().getBoolean("isDating") && entity.getPersistentData().getDouble("affection") >= 29) {
							entity.getPersistentData().putBoolean("isEngaged", (true));
							if (sourceentity instanceof ServerPlayer _player) {
								Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("mudrock_bode_mod:be_engaged_to_mudrock"));
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									Iterator _iterator = _ap.getRemainingCriteria().iterator();
									while (_iterator.hasNext())
										_player.getAdvancements().award(_adv, (String) _iterator.next());
								}
							}
							if (sourceentity instanceof Player _player) {
								ItemStack _stktoremove = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 5, 3, 3, 3, 1);
							if (!world.isClientSide()) {
								MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
								if (_mcserv != null)
									_mcserv.getPlayerList().broadcastSystemMessage(Component.literal((entity.getPersistentData().getString("waifuName") + ": " + "Yes! Me and my friends love you!")), false);
							}
						} else {
							if (!world.isClientSide()) {
								MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
								if (_mcserv != null)
									_mcserv.getPlayerList().broadcastSystemMessage(Component.literal((entity.getPersistentData().getString("waifuName") + ": " + "Sorry... But I don't fell confort with that now...")), false);
							}
						}
					} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MudrockBodeModModItems.WEDDING_RING.get()) {
						if (entity.getPersistentData().getBoolean("isEngaged") && entity.getPersistentData().getDouble("affection") >= 49) {
							entity.getPersistentData().putBoolean("isMarried", (true));
							if (sourceentity instanceof ServerPlayer _player) {
								Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("mudrock_bode_mod:marry_mudrock"));
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									Iterator _iterator = _ap.getRemainingCriteria().iterator();
									while (_iterator.hasNext())
										_player.getAdvancements().award(_adv, (String) _iterator.next());
								}
							}
							if (sourceentity instanceof Player _player) {
								ItemStack _stktoremove = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 5, 3, 3, 3, 1);
							if (!world.isClientSide()) {
								MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
								if (_mcserv != null)
									_mcserv.getPlayerList().broadcastSystemMessage(Component.literal((entity.getPersistentData().getString("waifuName") + ": " + "Oh! I... I think I will accept your proposal...")), false);
							}
						} else {
							if (!world.isClientSide()) {
								MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
								if (_mcserv != null)
									_mcserv.getPlayerList().broadcastSystemMessage(Component.literal((entity.getPersistentData().getString("waifuName") + ": " + "Sorry... But I don't think it's time for that yet...")), false);
							}
						}
					}
				}
			}
		}
	}
}
