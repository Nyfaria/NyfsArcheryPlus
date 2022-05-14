package com.nyfaria.nyfsarcheryplus.items;

import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CreativeModeTab;

import net.minecraft.world.item.Item.Properties;

public class GoldBowItem extends BowItem {

	public GoldBowItem(Properties properties) {
		super(new Properties().stacksTo(1).defaultDurability(538).tab(CreativeModeTab.TAB_COMBAT));
	}

}
