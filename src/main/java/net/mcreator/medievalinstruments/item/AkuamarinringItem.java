
package net.mcreator.medievalinstruments.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.medievalinstruments.MedievalInstrumentsModElements;

@MedievalInstrumentsModElements.ModElement.Tag
public class AkuamarinringItem extends MedievalInstrumentsModElements.ModElement {
	@ObjectHolder("medieval_instruments_:akuamarinring")
	public static final Item block = null;
	public AkuamarinringItem(MedievalInstrumentsModElements instance) {
		super(instance, 4);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).isImmuneToFire().rarity(Rarity.EPIC));
			setRegistryName("akuamarinring");
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
