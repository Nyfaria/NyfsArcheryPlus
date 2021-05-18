package com.nyfaria.nyfsarcheryplus.items;

import net.minecraft.item.BowItem;
import net.minecraft.item.ItemGroup;

public class GoldBowItem extends BowItem {

	public GoldBowItem(Properties properties) {
		super(new Properties().stacksTo(1).defaultDurability(538).tab(ItemGroup.TAB_COMBAT));
	}

}
