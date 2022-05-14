package com.nyfaria.nyfsarcheryplus.items;


import com.nyfaria.nyfsarcheryplus.EntityInit;
import com.nyfaria.nyfsarcheryplus.entities.DiamondTippedArrowEntity;
import com.nyfaria.nyfsarcheryplus.entities.StoneTippedArrowEntity;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;

import net.minecraft.world.item.Item.Properties;

public class DiamondTippedArrowItem extends ArrowItem {

	public DiamondTippedArrowItem(Properties properties) {		
		super(properties);
		
	}
	@Override
	public AbstractArrow createArrow(Level world, ItemStack stack, LivingEntity player) {
		return new DiamondTippedArrowEntity(EntityInit.DTA_ENTITYTYPE, player, world);
	}
	@Override
    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.world.entity.player.Player player) {
        int enchant = net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.world.item.enchantment.Enchantments.INFINITY_ARROWS, bow);
        return enchant > 0 && this.getClass() == DiamondTippedArrowItem.class;
    }
    @SubscribeEvent
	public void onTick(TickEvent.WorldTickEvent event){
		if(event.side == LogicalSide.SERVER)
			if(event.world.getGameTime() % 12000 == 0){

			}
	}
}
