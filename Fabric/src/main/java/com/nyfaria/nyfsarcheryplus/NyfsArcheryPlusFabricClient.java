package com.nyfaria.nyfsarcheryplus;

import com.nyfaria.nyfsarcheryplus.client.renderer.AdvancedTippedArrowRenderer;
import com.nyfaria.nyfsarcheryplus.enums.ArcheryTiers;
import com.nyfaria.nyfsarcheryplus.init.CommonClientInit;
import com.nyfaria.nyfsarcheryplus.init.EntityInit;
import com.nyfaria.nyfsarcheryplus.interfaces.IArcherCollection;
import com.nyfaria.nyfsarcheryplus.platform.Services;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;

public class NyfsArcheryPlusFabricClient implements ClientModInitializer {
    
    @Override
    public void onInitializeClient() {
        CommonClientInit.clientSetup();
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(
                (tab) -> {
                    for(ArcheryTiers tier :ArcheryTiers.values()){
                        IArcherCollection collection = Services.PLATFORM.getArcherCollection(tier);
                        tab.accept(collection.getTippedArrow());
                        tab.accept(collection.getArrowTip());
                        if(tier != ArcheryTiers.STONE) {
                            tab.accept(collection.getBow());
                            tab.accept(collection.getCrossbow());
                        }
                    }
                }
        );
        EntityRendererRegistry.register(EntityInit.ADVANCED_TIPPED_ARROW_ENTITY, AdvancedTippedArrowRenderer::new);
    }

}
