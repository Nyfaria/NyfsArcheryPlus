package com.nyfaria.nyfsarcheryplus.init;

import com.nyfaria.nyfsarcheryplus.Constants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class TagInit {

    public static final TagKey<Item> STONE = TagKey.create(BuiltInRegistries.ITEM.key() , new ResourceLocation(Constants.MODID,"stone"));

    public static void init(){

    }
}
