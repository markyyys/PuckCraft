package net.mcreator.weapony.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.weapony.init.WeaponyModItems;

public class GunCanUseRangedItemProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(WeaponyModItems.AMMO.get())) : false;
	}
}
