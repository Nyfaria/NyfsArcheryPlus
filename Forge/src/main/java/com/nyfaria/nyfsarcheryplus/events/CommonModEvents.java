package com.nyfaria.nyfsarcheryplus.events;

import com.nyfaria.nyfsarcheryplus.init.ItemInit;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Iterator;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModEvents {
    @SubscribeEvent
    public static void creativeModTabs(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.COMBAT){
            ItemInit.ITEMS.getEntries().forEach(event::accept);
            			Iterator var3 = BuiltInRegistries.POTION.iterator();

			while(var3.hasNext()) {
				Potion $$2 = (Potion) var3.next();
				if (!$$2.getEffects().isEmpty()) {
					event.accept(PotionUtils.setPotion(new ItemStack(ItemInit.STONE_COLLECTION.getTippedArrow()), $$2));
                    event.accept(PotionUtils.setPotion(new ItemStack(ItemInit.IRON_COLLECTION.getTippedArrow()), $$2));
                    event.accept(PotionUtils.setPotion(new ItemStack(ItemInit.GOLD_COLLECTION.getTippedArrow()), $$2));
                    event.accept(PotionUtils.setPotion(new ItemStack(ItemInit.DIAMOND_COLLECTION.getTippedArrow()), $$2));
                    event.accept(PotionUtils.setPotion(new ItemStack(ItemInit.NETHERITE_COLLECTION.getTippedArrow()), $$2));
				}
			}
        }
    }
}
