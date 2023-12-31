package net.mcreator.mudrockbodemod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.mudrockbodemod.world.inventory.WaifuInventoryMenu;
import net.mcreator.mudrockbodemod.procedures.WaifuRelationshipGUIValorProcedure;
import net.mcreator.mudrockbodemod.procedures.WaifuNameGUIValorProcedure;
import net.mcreator.mudrockbodemod.procedures.WaifuAffectionGUIValorProcedure;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class WaifuInventoryScreen extends AbstractContainerScreen<WaifuInventoryMenu> {
	private final static HashMap<String, Object> guistate = WaifuInventoryMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public WaifuInventoryScreen(WaifuInventoryMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("mudrock_bode_mod:textures/screens/waifu_inventory.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack,

				WaifuNameGUIValorProcedure.execute(world), 4, 6, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.mudrock_bode_mod.waifu_inventory.label_armor"), 5, 19, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.mudrock_bode_mod.waifu_inventory.label_weapon"), 55, 19, -12829636);
		this.font.draw(poseStack,

				WaifuAffectionGUIValorProcedure.execute(world), 48, 54, -12829636);
		this.font.draw(poseStack,

				WaifuRelationshipGUIValorProcedure.execute(world), 5, 70, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
	}
}
