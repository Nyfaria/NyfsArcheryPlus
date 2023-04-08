package com.nyfaria.nyfsarcheryplus.init;

import com.nyfaria.nyfsarcheryplus.Constants;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class TagInit {

    public static final TagKey<Item> STONE = TagKey.create(Registry.ITEM_REGISTRY , new ResourceLocation(Constants.MODID,"stone"));

    public static void init(){

    }
}
