package com.nyfaria.nyfsarcheryplus.items;


import com.nyfaria.nyfsarcheryplus.EntityInit;
import com.nyfaria.nyfsarcheryplus.entities.DiamondTippedArrowEntity;
import com.nyfaria.nyfsarcheryplus.entities.StoneTippedArrowEntity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DiamondTippedArrowItem extends ArrowItem {

	public DiamondTippedArrowItem(Properties properties) {		
		super(properties);
		
	}
	@Override
	public AbstractArrowEntity createArrow(World world, ItemStack stack, LivingEntity player) {
		return new DiamondTippedArrowEntity(EntityInit.DTA_ENTITYTYPE, player, world);
	}
	@Override
    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.PlayerEntity player) {
        int enchant = net.minecraft.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.enchantment.Enchantments.INFINITY_ARROWS, bow);
        return enchant > 0 && this.getClass() == DiamondTippedArrowItem.class;
    }
}
