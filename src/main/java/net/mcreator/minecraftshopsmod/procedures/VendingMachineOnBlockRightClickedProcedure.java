package net.mcreator.minecraftshopsmod.procedures;

import net.minecraftforge.fml.network.NetworkHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.PacketBuffer;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.minecraftshopsmod.gui.VendingGUIGui;
import net.mcreator.minecraftshopsmod.MinecraftShopsModModElements;
import net.mcreator.minecraftshopsmod.MinecraftShopsModMod;

import java.util.Map;

import io.netty.buffer.Unpooled;

@MinecraftShopsModModElements.ModElement.Tag
public class VendingMachineOnBlockRightClickedProcedure extends MinecraftShopsModModElements.ModElement {
	public VendingMachineOnBlockRightClickedProcedure(MinecraftShopsModModElements instance) {
		super(instance, 23);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftShopsModMod.LOGGER.warn("Failed to load dependency entity for procedure VendingMachineOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MinecraftShopsModMod.LOGGER.warn("Failed to load dependency x for procedure VendingMachineOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MinecraftShopsModMod.LOGGER.warn("Failed to load dependency y for procedure VendingMachineOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MinecraftShopsModMod.LOGGER.warn("Failed to load dependency z for procedure VendingMachineOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MinecraftShopsModMod.LOGGER.warn("Failed to load dependency world for procedure VendingMachineOnBlockRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).closeScreen();
		{
			Entity _ent = entity;
			if (_ent instanceof ServerPlayerEntity) {
				BlockPos _bpos = new BlockPos((int) x, (int) y, (int) z);
				NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
					@Override
					public ITextComponent getDisplayName() {
						return new StringTextComponent("VendingGUI");
					}

					@Override
					public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
						return new VendingGUIGui.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
	}
}
