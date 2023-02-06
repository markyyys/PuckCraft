package net.mcreator.weapony.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.weapony.init.WeaponyModItems;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Random;

public class GunRangedItemUsedProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack currentAmmo = ItemStack.EMPTY;
		ItemStack newItem = ItemStack.EMPTY;
		{
			AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
			entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> _iitemhandlerref.set(capability));
			if (_iitemhandlerref.get() != null) {
				for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
					ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
					if (itemstackiterator.getItem() == WeaponyModItems.AMMO.get()) {
						newItem = itemstackiterator;
						if ((itemstackiterator).getDamageValue() != 0) {
							currentAmmo = itemstackiterator;
						}
					}
				}
			}
		}
		if (currentAmmo.getItem() == (ItemStack.EMPTY).getItem()) {
			currentAmmo = newItem;
		}
		if (entity instanceof Player _player) {
			ItemStack _stktoremove = currentAmmo;
			_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
		}
		{
			ItemStack _ist = currentAmmo;
			if (_ist.hurt(1, new Random(), null)) {
				_ist.shrink(1);
				_ist.setDamageValue(0);
			}
		}
		if (currentAmmo.getItem() == (ItemStack.EMPTY).getItem()) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(WeaponyModItems.AMMO_EMPTY.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 100);
		} else {
			if (entity instanceof Player _player) {
				ItemStack _setstack = currentAmmo;
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
	}
}
