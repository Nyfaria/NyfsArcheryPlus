package com.nyfaria.nyfsarcheryplus.items;

import net.minecraft.item.BowItem;
import net.minecraft.item.ItemGroup;

public class IronBowItem extends BowItem {

	public IronBowItem(Properties properties) {
		super(new Properties().stacksTo(1).defaultDurability(1152).tab(ItemGroup.TAB_COMBAT));		
	}

}
