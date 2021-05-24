package com.nyfaria.nyfsarcheryplus.items;

import net.minecraft.item.BowItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ArmorMaterial;

public class DiamondBowItem extends BowItem {
    
	public DiamondBowItem(Properties properties) {
		super(new Properties().stacksTo(1).defaultDurability(2534).tab(ItemGroup.TAB_COMBAT));
	}
	@Override
	public boolean isValidRepairItem(ItemStack p_82789_1_, ItemStack p_82789_2_) {
		if(p_82789_2_.getItem() == Items.DIAMOND_SWORD) {
			return true;
		}
		return false;
	}
}
