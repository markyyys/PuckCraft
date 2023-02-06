
package net.mcreator.weapony.item;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

public class AmmoEmptyItem extends Item {
	public AmmoEmptyItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).durability(100).rarity(Rarity.COMMON));
	}

	@Override
	public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
		return 2F;
	}
}
