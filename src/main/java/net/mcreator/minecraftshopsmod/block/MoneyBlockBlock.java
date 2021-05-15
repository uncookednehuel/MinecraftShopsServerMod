
package net.mcreator.minecraftshopsmod.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.minecraftshopsmod.itemgroup.MinecraftShopsModTabItemGroup;
import net.mcreator.minecraftshopsmod.item.FiveHundredDollarBillItem;
import net.mcreator.minecraftshopsmod.MinecraftShopsModModElements;

import java.util.List;
import java.util.Collections;

@MinecraftShopsModModElements.ModElement.Tag
public class MoneyBlockBlock extends MinecraftShopsModModElements.ModElement {
	@ObjectHolder("minecraft_shops_mod:money_block")
	public static final Block block = null;
	public MoneyBlockBlock(MinecraftShopsModModElements instance) {
		super(instance, 26);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(
				() -> new BlockItem(block, new Item.Properties().group(MinecraftShopsModTabItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ORGANIC).sound(SoundType.GROUND).hardnessAndResistance(0.5f, 1f).setLightLevel(s -> 0));
			setRegistryName("money_block");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(FiveHundredDollarBillItem.block, (int) (9)));
		}
	}
}
