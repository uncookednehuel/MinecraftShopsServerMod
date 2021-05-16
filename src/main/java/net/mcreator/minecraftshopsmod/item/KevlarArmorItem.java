
package net.mcreator.minecraftshopsmod.item;

@MinecraftShopsModModElements.ModElement.Tag
public class KevlarArmorItem extends MinecraftShopsModModElements.ModElement {

	@ObjectHolder("minecraft_shops_mod:kevlar_armor_helmet")
	public static final Item helmet = null;

	@ObjectHolder("minecraft_shops_mod:kevlar_armor_chestplate")
	public static final Item body = null;

	@ObjectHolder("minecraft_shops_mod:kevlar_armor_leggings")
	public static final Item legs = null;

	@ObjectHolder("minecraft_shops_mod:kevlar_armor_boots")
	public static final Item boots = null;

	public KevlarArmorItem(MinecraftShopsModModElements instance) {
		super(instance, 22);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 29;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{2, 5, 6, 2}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 9;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_netherite"));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "kevlar_armor";
			}

			@Override
			public float getToughness() {
				return 0f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		};

		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(MinecraftShopsModTabItemGroup.tab)) {

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "minecraft_shops_mod:textures/models/armor/kevlar_armor_temp_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1")
								+ ".png";
					}

				}.setRegistryName("kevlar_armor_helmet"));

		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(MinecraftShopsModTabItemGroup.tab)) {

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "minecraft_shops_mod:textures/models/armor/kevlar_armor_temp_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1")
								+ ".png";
					}

				}.setRegistryName("kevlar_armor_chestplate"));

		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(MinecraftShopsModTabItemGroup.tab)) {

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "minecraft_shops_mod:textures/models/armor/kevlar_armor_temp_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1")
								+ ".png";
					}

				}.setRegistryName("kevlar_armor_leggings"));

		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(MinecraftShopsModTabItemGroup.tab)) {

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "minecraft_shops_mod:textures/models/armor/kevlar_armor_temp_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1")
								+ ".png";
					}

				}.setRegistryName("kevlar_armor_boots"));
	}

}
