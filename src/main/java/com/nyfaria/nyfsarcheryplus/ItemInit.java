package com.nyfaria.nyfsarcheryplus;

import com.nyfaria.nyfsarcheryplus.items.DiamondBowItem;
import com.nyfaria.nyfsarcheryplus.items.GoldBowItem;
import com.nyfaria.nyfsarcheryplus.items.IronBowItem;
import com.nyfaria.nyfsarcheryplus.items.NetheriteBowItem;
import com.nyfaria.nyfsarcheryplus.items.StoneArrowTipItem;
import com.nyfaria.nyfsarcheryplus.items.StoneTippedArrowItem;

import net.minecraft.item.ArrowItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NyfsBows.MOD_ID);

	public static final RegistryObject<IronBowItem> IRON_BOW = ITEMS.register("iron_bow", () -> new IronBowItem(new Item.Properties()));
	public static final RegistryObject<GoldBowItem> GOLD_BOW = ITEMS.register("gold_bow", () -> new GoldBowItem(new Item.Properties()));
	public static final RegistryObject<DiamondBowItem> DIAMOND_BOW = ITEMS.register("diamond_bow", () -> new DiamondBowItem(new Item.Properties()));
	public static final RegistryObject<NetheriteBowItem> NETHERITE_BOW = ITEMS.register("netherite_bow", () -> new NetheriteBowItem(new Item.Properties()));
	public static final RegistryObject<StoneArrowTipItem> STONE_ARROW_TIP = ITEMS.register("stone_arrow_tip", () -> new StoneArrowTipItem(new Item.Properties().stacksTo(64)));
	public static final RegistryObject<StoneTippedArrowItem> STONE_TIPPED_ARROW = ITEMS.register("stone_tipped_arrow", () -> new StoneTippedArrowItem(new Item.Properties().stacksTo(64).tab(ItemGroup.TAB_COMBAT)));

}
