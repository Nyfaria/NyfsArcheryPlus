package com.nyfaria.nyfsarcheryplus.items;

import net.minecraft.item.BowItem;
import net.minecraft.item.ItemGroup;

public class DiamondBowItem extends BowItem {
    
	public DiamondBowItem(Properties properties) {
		super(new Properties().stacksTo(1).defaultDurability(2534).tab(ItemGroup.TAB_COMBAT));
	}
}
