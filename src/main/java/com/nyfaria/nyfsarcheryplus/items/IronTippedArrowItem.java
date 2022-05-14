package com.nyfaria.nyfsarcheryplus.items;


import com.nyfaria.nyfsarcheryplus.EntityInit;
import com.nyfaria.nyfsarcheryplus.entities.StoneTippedArrowEntity;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import net.minecraft.world.item.Item.Properties;

public class IronTippedArrowItem extends ArrowItem {

	public IronTippedArrowItem(Properties properties) {		
		super(properties);
		
	}
	@Override
	public AbstractArrow createArrow(Level world, ItemStack stack, LivingEntity player) {
		StoneTippedArrowEntity arrowentity = new StoneTippedArrowEntity(EntityInit.ITA_ENTITYTYPE, player, world);
		return arrowentity;
	}
	@Override
    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.world.entity.player.Player player) {
        int enchant = net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.world.item.enchantment.Enchantments.INFINITY_ARROWS, bow);
        return enchant <= 0 ? false : this.getClass() == IronTippedArrowItem.class;
    }
}
