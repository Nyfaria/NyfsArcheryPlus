package com.nyfaria.nyfsarcheryplus.item;

import com.nyfaria.nyfsarcheryplus.Constants;
import com.nyfaria.nyfsarcheryplus.enums.ArcheryTiers;
import com.nyfaria.nyfsarcheryplus.interfaces.IArcherCollection;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class ArcheryCollection<T extends Item> implements IArcherCollection {

    private final ArcheryTiers tier;
    private final AdvancedBowItem bow;
    private final AdvancedCrossBowItem crossbow;
    private final Item arrowTip;
    private final AdvancedTippedArrowItem tippedArrow;

    public ArcheryCollection(ArcheryTiers tier, AdvancedBowItem bow, AdvancedCrossBowItem crossbow, Item arrowTip, AdvancedTippedArrowItem tippedArrow) {
        this.tier = tier;
        this.bow = bow;
        this.crossbow = crossbow;
        this.arrowTip = arrowTip;
        this.tippedArrow = tippedArrow;
    }
    public static ArcheryCollection<Item> registerCollection(ArcheryTiers tier) {
        return new ArcheryCollection<>(
                tier,
                Registry.register(Registry.ITEM, new ResourceLocation(Constants.MODID,tier.getName() + "_bow"), new AdvancedBowItem(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT),tier)),
                Registry.register(Registry.ITEM, new ResourceLocation(Constants.MODID,tier.getName() + "_crossbow"), new AdvancedCrossBowItem(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT),tier)),
                Registry.register(Registry.ITEM, new ResourceLocation(Constants.MODID,tier.getName() + "_arrowhead"), new Item(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT))),
                Registry.register(Registry.ITEM, new ResourceLocation(Constants.MODID,tier.getName() + "_tipped_arrow"), new AdvancedTippedArrowItem(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT),tier))
        );
    }
    public ArcheryTiers getTier() {
        return tier;
    }
    public Item getBow() {
        if(bow == null)
            return null;
        return bow;
    }
    public Item getCrossbow() {
        if(crossbow == null)
            return null;
        return crossbow;
    }
    public Item getArrowTip() {
        return arrowTip;
    }
    public Item getTippedArrow() {
        return tippedArrow;
    }
}