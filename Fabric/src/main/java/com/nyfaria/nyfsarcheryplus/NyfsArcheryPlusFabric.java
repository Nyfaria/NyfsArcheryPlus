package com.nyfaria.nyfsarcheryplus;

import com.nyfaria.nyfsarcheryplus.init.CommonInit;
import com.nyfaria.nyfsarcheryplus.init.EntityInit;
import com.nyfaria.nyfsarcheryplus.init.ItemInit;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;

import java.util.Iterator;
import java.util.function.Supplier;

public class NyfsArcheryPlusFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        
        // This method is invoked by the Fabric mod loader when it is ready
        // to load your mod. You can access Fabric and Common code in this
        // project.

        // Use Fabric to bootstrap the Common mod.
        Constants.LOG.info("Hello Fabric world!");
        CommonClass.init();
        CommonInit.preInit();

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register((event) -> {
            ItemInit.ITEMS.getEntries().stream().map(Supplier::get).forEach(event::accept);
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
        });
    }
}
