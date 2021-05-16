
package net.mcreator.minecraftshopsmod.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.minecraftshopsmod.MinecraftShopsModMod;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class VendingGUIGuiWindow extends ContainerScreen<VendingGUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	public VendingGUIGuiWindow(VendingGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}
	private static final ResourceLocation texture = new ResourceLocation("minecraft_shops_mod:textures/vending_gui.png");
	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Deposite Money", 27, 65, -12829636);
		this.font.drawString(ms, "item", 6, 9, -10066432);
		this.font.drawString(ms, "item", 6, 34, -10066432);
		this.font.drawString(ms, "item", 79, 10, -10066432);
		this.font.drawString(ms, "cost", 6, 44, -16751053);
		this.font.drawString(ms, "cost", 6, 20, -16751053);
		this.font.drawString(ms, "cost", 79, 20, -16751053);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new Button(this.guiLeft + 33, this.guiTop + 9, 40, 20, new StringTextComponent("Buy"), e -> {
			if (true) {
				MinecraftShopsModMod.PACKET_HANDLER.sendToServer(new VendingGUIGui.ButtonPressedMessage(0, x, y, z));
				VendingGUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 33, this.guiTop + 34, 40, 20, new StringTextComponent("Buy"), e -> {
			if (true) {
				MinecraftShopsModMod.PACKET_HANDLER.sendToServer(new VendingGUIGui.ButtonPressedMessage(1, x, y, z));
				VendingGUIGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 106, this.guiTop + 10, 40, 20, new StringTextComponent("Buy"), e -> {
			if (true) {
				MinecraftShopsModMod.PACKET_HANDLER.sendToServer(new VendingGUIGui.ButtonPressedMessage(2, x, y, z));
				VendingGUIGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 76, this.guiTop + 34, 70, 20, new StringTextComponent("Next Page"), e -> {
			if (true) {
				MinecraftShopsModMod.PACKET_HANDLER.sendToServer(new VendingGUIGui.ButtonPressedMessage(3, x, y, z));
				VendingGUIGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
	}
}
