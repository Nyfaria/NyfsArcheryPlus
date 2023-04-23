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
        EntityRendererRegistry.register(EntityInit.ADVANCED_TIPPED_ARROW_ENTITY.get(), AdvancedTippedArrowRenderer::new);

    }

}
