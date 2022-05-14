package com.nyfaria.nyfsarcheryplus.items;

import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CreativeModeTab;

import net.minecraft.world.item.Item.Properties;

public class IronBowItem extends BowItem {

	public IronBowItem(Properties properties) {
		super(new Properties().stacksTo(1).defaultDurability(1152).tab(CreativeModeTab.TAB_COMBAT));		
	}

}
