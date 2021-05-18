package com.nyfaria.nyfsarcheryplus.items;


import com.nyfaria.nyfsarcheryplus.EntityInit;
import com.nyfaria.nyfsarcheryplus.entities.StoneTippedArrowEntity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class StoneTippedArrowItem extends ArrowItem {

	public StoneTippedArrowItem(Properties properties) {		
		super(properties);
		
	}
	@Override
	public AbstractArrowEntity createArrow(World world, ItemStack stack, LivingEntity player) {
		StoneTippedArrowEntity arrowentity = new StoneTippedArrowEntity(EntityInit.STA_ENTITYTYPE, player, world);
		return arrowentity;
	}
	@Override
    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.PlayerEntity player) {
        int enchant = net.minecraft.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.enchantment.Enchantments.INFINITY_ARROWS, bow);
        return enchant <= 0 ? false : this.getClass() == StoneTippedArrowItem.class;
    }
}
