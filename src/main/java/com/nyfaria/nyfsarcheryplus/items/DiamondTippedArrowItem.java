package com.nyfaria.nyfsarcheryplus.items;


import com.nyfaria.nyfsarcheryplus.EntityInit;
import com.nyfaria.nyfsarcheryplus.entities.DiamondTippedArrowEntity;
import com.nyfaria.nyfsarcheryplus.entities.StoneTippedArrowEntity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;

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
    @SubscribeEvent
	public void onTick(TickEvent.WorldTickEvent event){
		if(event.side == LogicalSide.SERVER)
			if(event.world.getGameTime() % 12000 == 0){

			}
	}
}
