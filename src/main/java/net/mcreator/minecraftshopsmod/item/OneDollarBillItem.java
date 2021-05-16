
package net.mcreator.minecraftshopsmod.item;

@MinecraftShopsModModElements.ModElement.Tag
public class OneDollarBillItem extends MinecraftShopsModModElements.ModElement {

	@ObjectHolder("minecraft_shops_mod:one_dollar_bill")
	public static final Item block = null;

	public OneDollarBillItem(MinecraftShopsModModElements instance) {
		super(instance, 21);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(MinecraftShopsModTabItemGroup.tab).maxStackSize(64).isImmuneToFire().rarity(Rarity.UNCOMMON));
			setRegistryName("one_dollar_bill");
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
