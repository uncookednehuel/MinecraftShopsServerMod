
package net.mcreator.minecraftshopsmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.minecraftshopsmod.itemgroup.MinecraftShopsModTabItemGroup;
import net.mcreator.minecraftshopsmod.MinecraftShopsModModElements;

@MinecraftShopsModModElements.ModElement.Tag
public class KevlarHelmetItem extends MinecraftShopsModModElements.ModElement {
	@ObjectHolder("minecraft_shops_mod:kevlar_helmet")
	public static final Item block = null;
	public KevlarHelmetItem(MinecraftShopsModModElements instance) {
		super(instance, 17);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(MinecraftShopsModTabItemGroup.tab).maxStackSize(57).rarity(Rarity.COMMON));
			setRegistryName("kevlar_helmet");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
