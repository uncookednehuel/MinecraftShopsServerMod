
package net.mcreator.minecraftshopsmod.item;

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
