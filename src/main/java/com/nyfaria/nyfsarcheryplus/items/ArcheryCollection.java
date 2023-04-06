package com.nyfaria.nyfsarcheryplus.items;

import com.nyfaria.nyfsarcheryplus.enums.ArcheryTiers;
import com.nyfaria.nyfsarcheryplus.init.ItemInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ArcheryCollection<T extends Item> {

    private final ArcheryTiers tier;
    private final RegistryObject<T> bow;
    private final RegistryObject<T> crossbow;
    private final RegistryObject<T> arrowTip;
    private final RegistryObject<T> tippedArrow;

    public ArcheryCollection(ArcheryTiers tier,RegistryObject<T> bow, RegistryObject<T> crossbow, RegistryObject<T> arrowTip, RegistryObject<T> tippedArrow) {
        this.tier = tier;
        this.bow = bow;
        this.crossbow = crossbow;
        this.arrowTip = arrowTip;
        this.tippedArrow = tippedArrow;
    }
    public static ArcheryCollection<Item> registerCollection(ArcheryTiers tier) {
        return new ArcheryCollection<>(
                tier,
                ItemInit.ITEMS.register(tier.getName() + "_bow", () -> new AdvancedBowItem(new Item.Properties(),tier)),
                ItemInit.ITEMS.register(tier.getName() + "_crossbow", () -> new AdvancedCrossBowItem(new Item.Properties(),tier)),
                ItemInit.ITEMS.register(tier.getName() + "_arrowhead", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT))),
                ItemInit.ITEMS.register(tier.getName() + "_tipped_arrow", () -> new AdvancedTippedArrowItem(new Item.Properties(),tier))
        );
    }
    public ArcheryTiers getTier() {
        return tier;
    }
    public Item getBow() {
        if(bow == null)
            return null;
        return bow.get();
    }
    public Item getCrossbow() {
        if(crossbow == null)
            return null;
        return crossbow.get();
    }
    public Item getArrowTip() {
        return arrowTip.get();
    }
    public Item getTippedArrow() {
        return tippedArrow.get();
    }
}
