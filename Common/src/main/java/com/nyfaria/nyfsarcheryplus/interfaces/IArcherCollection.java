package com.nyfaria.nyfsarcheryplus.interfaces;

import com.nyfaria.nyfsarcheryplus.enums.ArcheryTiers;
import net.minecraft.world.item.Item;

public interface IArcherCollection {

        ArcheryTiers getTier();
        Item getBow();
        Item getCrossbow();
        Item getArrowTip();
        Item getTippedArrow();
}
