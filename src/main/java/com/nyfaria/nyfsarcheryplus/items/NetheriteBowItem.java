package com.nyfaria.nyfsarcheryplus.items;

import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CreativeModeTab;

import net.minecraft.world.item.Item.Properties;

public class NetheriteBowItem extends BowItem {

	public NetheriteBowItem(Properties properties) {
		super(new Properties().stacksTo(1).defaultDurability(2842).tab(CreativeModeTab.TAB_COMBAT));
	}

}
