package com.nyfaria.nyfsarcheryplus;

import com.nyfaria.nyfsarcheryplus.client.renderer.AdvancedTippedArrowRenderer;
import com.nyfaria.nyfsarcheryplus.init.CommonClientInit;
import com.nyfaria.nyfsarcheryplus.init.EntityInit;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class NyfsArcheryPlusFabricClient implements ClientModInitializer {
    
    @Override
    public void onInitializeClient() {
        CommonClientInit.clientSetup();
//        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(
//                (tab) -> ItemInit.ITEMS.getEntries().stream().map(Supplier::get).map(ItemStack::new)
//                        .forEach(stack->{
//                            tab.accept(stack);
//                            if(stack.getItem() instanceof AdvancedTippedArrowItem){
//                                for(Potion potion : BuiltInRegistries.POTION) {
//                                    if (potion != Potions.EMPTY) {
//                                        tab.accept(PotionUtils.setPotion(stack.copy(), potion));
//                                    }
//                                }
//                            }
//                        })
//        );
        EntityRendererRegistry.register(EntityInit.ADVANCED_TIPPED_ARROW_ENTITY.get(), AdvancedTippedArrowRenderer::new);

    }

}
