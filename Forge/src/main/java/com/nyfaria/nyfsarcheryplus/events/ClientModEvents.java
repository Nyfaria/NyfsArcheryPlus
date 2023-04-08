package com.nyfaria.nyfsarcheryplus.events;

import com.nyfaria.nyfsarcheryplus.Constants;
import com.nyfaria.nyfsarcheryplus.client.renderer.AdvancedTippedArrowRenderer;
import com.nyfaria.nyfsarcheryplus.init.CommonClientInit;
import com.nyfaria.nyfsarcheryplus.init.EntityInit;
import com.nyfaria.nyfsarcheryplus.init.ItemInit;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Constants.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientModEvents {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        CommonClientInit.clientSetup();
    }
    @SubscribeEvent
    public static void onCreativeTabAdd(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab()== CreativeModeTabs.COMBAT){
            ItemInit.ITEMS.getEntries().forEach(item->event.accept(item.get().getDefaultInstance()));
        }
    }
    @SubscribeEvent
    public static void onEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.ADVANCED_TIPPED_ARROW_ENTITY.get(), AdvancedTippedArrowRenderer::new);
    }
}
