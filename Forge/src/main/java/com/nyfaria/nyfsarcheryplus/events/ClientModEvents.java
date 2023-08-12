package com.nyfaria.nyfsarcheryplus.events;

import com.nyfaria.nyfsarcheryplus.Constants;
import com.nyfaria.nyfsarcheryplus.client.renderer.AdvancedTippedArrowRenderer;
import com.nyfaria.nyfsarcheryplus.init.CommonClientInit;
import com.nyfaria.nyfsarcheryplus.init.EntityInit;
import com.nyfaria.nyfsarcheryplus.init.ItemInit;
import com.nyfaria.nyfsarcheryplus.item.ArcheryCollection;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.stream.Stream;

@Mod.EventBusSubscriber(modid = Constants.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        CommonClientInit.clientSetup();
    }
//    @SubscribeEvent
//    public static void onCreativeTabAdd(CreativeModeTabEvent.BuildContents event) {
//        if(event.getTab()== CreativeModeTabs.COMBAT){
//            ItemInit.ITEMS.getEntries().stream().map(Supplier::get).map(ItemStack::new)
//                    .forEach(stack->{
//                        event.accept(stack);
//                        if(stack.getItem() instanceof AdvancedTippedArrowItem){
//                            for(Potion potion : BuiltInRegistries.POTION) {
//                                if (potion != Potions.EMPTY) {
//                                    event.accept(PotionUtils.setPotion(stack.copy(), potion));
//                                }
//                            }
//                        }
//                    });
//        }
//    }
    @SubscribeEvent
    public static void onEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.ADVANCED_TIPPED_ARROW_ENTITY.get(), AdvancedTippedArrowRenderer::new);
    }
    @SubscribeEvent
    public static void onItemColors(RegisterColorHandlersEvent.Item event) {
        Stream.of(
                ItemInit.DIAMOND_COLLECTION,
                ItemInit.GOLD_COLLECTION,
                ItemInit.IRON_COLLECTION,
                ItemInit.NETHERITE_COLLECTION,
                ItemInit.STONE_COLLECTION
        ).map(ArcheryCollection::getTippedArrow)
                .forEach(item -> event.register((stack, tintIndex) -> {
                    if (tintIndex == 0 && stack.hasTag() && stack.getTag().contains("Potion")) {
                        return PotionUtils.getColor(stack);
                    } else {
                        return -1;
                    }
                }, item));
    }
}
