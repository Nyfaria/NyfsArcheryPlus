package com.nyfaria.nyfsarcheryplus.items;

import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.item.ArmorMaterial;

import net.minecraft.world.item.Item.Properties;

public class DiamondBowItem extends BowItem {
    
	public DiamondBowItem(Properties properties) {
		super(new Properties().stacksTo(1).defaultDurability(2534).tab(CreativeModeTab.TAB_COMBAT));
	}
	@Override
	public boolean isValidRepairItem(ItemStack p_82789_1_, ItemStack p_82789_2_) {
		if(p_82789_2_.getItem() == Items.DIAMOND) {
			return true;
		}
		return false;
	}
}
