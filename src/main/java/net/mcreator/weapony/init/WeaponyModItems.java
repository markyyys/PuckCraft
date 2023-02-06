
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.weapony.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.weapony.item.GunItem;
import net.mcreator.weapony.item.AmmoItem;
import net.mcreator.weapony.item.AmmoEmptyItem;
import net.mcreator.weapony.WeaponyMod;

public class WeaponyModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, WeaponyMod.MODID);
	public static final RegistryObject<Item> AMMO = REGISTRY.register("ammo", () -> new AmmoItem());
	public static final RegistryObject<Item> GUN = REGISTRY.register("gun", () -> new GunItem());
	public static final RegistryObject<Item> AMMO_EMPTY = REGISTRY.register("ammo_empty", () -> new AmmoEmptyItem());
}
