package com.nyfaria.nyfsarcheryplus.items;

import java.util.function.Predicate;

import com.nyfaria.nyfsarcheryplus.ItemInit;

import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class DiamondBowItem extends BowItem {
    
	public DiamondBowItem(Properties properties) {
		super(new Properties().stacksTo(1).defaultDurability(2534));
	}
}
