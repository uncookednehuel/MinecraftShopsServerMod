
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
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.minecraftshopsmod.MinecraftShopsModMod;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class OwnerVendingGuiGuiWindow extends ContainerScreen<OwnerVendingGuiGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	TextFieldWidget Cost;
	TextFieldWidget Amount;
	public OwnerVendingGuiGuiWindow(OwnerVendingGuiGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}
	private static final ResourceLocation texture = new ResourceLocation("minecraft_shops_mod:textures/owner_vending_gui.png");
	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
		Cost.render(ms, mouseX, mouseY, partialTicks);
		Amount.render(ms, mouseX, mouseY, partialTicks);
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
		if (Cost.isFocused())
			return Cost.keyPressed(key, b, c);
		if (Amount.isFocused())
			return Amount.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
		Cost.tick();
		Amount.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Label text", 6, 25, -12829636);
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
		Cost = new TextFieldWidget(this.font, this.guiLeft + 6, this.guiTop + 58, 120, 20, new StringTextComponent("Cost")) {
			{
				setSuggestion("Cost");
			}
			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("Cost");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("Cost");
				else
					setSuggestion(null);
			}
		};
		OwnerVendingGuiGui.guistate.put("text:Cost", Cost);
		Cost.setMaxStringLength(32767);
		this.children.add(this.Cost);
		Amount = new TextFieldWidget(this.font, this.guiLeft + 6, this.guiTop + 38, 120, 20, new StringTextComponent("Amount Per Sale")) {
			{
				setSuggestion("Amount Per Sale");
			}
			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("Amount Per Sale");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("Amount Per Sale");
				else
					setSuggestion(null);
			}
		};
		OwnerVendingGuiGui.guistate.put("text:Amount", Amount);
		Amount.setMaxStringLength(32767);
		this.children.add(this.Amount);
		this.addButton(new Button(this.guiLeft + 81, this.guiTop + 3, 90, 20, new StringTextComponent("Collect Funds"), e -> {
			if (true) {
				MinecraftShopsModMod.PACKET_HANDLER.sendToServer(new OwnerVendingGuiGui.ButtonPressedMessage(0, x, y, z));
				OwnerVendingGuiGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
