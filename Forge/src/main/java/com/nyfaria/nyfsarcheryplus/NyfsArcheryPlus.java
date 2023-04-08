package com.nyfaria.nyfsarcheryplus;

import com.nyfaria.nyfsarcheryplus.datagen.ModLangProvider;
import com.nyfaria.nyfsarcheryplus.datagen.ModRecipeProvider;
import com.nyfaria.nyfsarcheryplus.init.CommonInit;
import com.nyfaria.nyfsarcheryplus.init.EntityInit;
import com.nyfaria.nyfsarcheryplus.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod(Constants.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NyfsArcheryPlus {
    
    public NyfsArcheryPlus() {

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);

        ItemInit.ITEMS.register(bus);
        EntityInit.ENTITIES.register(bus);
    }

    public void setup(final FMLCommonSetupEvent event) {
        CommonInit.preInit();
    }
    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        boolean includeServer = event.includeServer();
        boolean includeClient = event.includeClient();

        if(includeServer) {
            generator.addProvider(new ModRecipeProvider(generator));
        }
        if(includeClient) {
            generator.addProvider(new ModLangProvider(generator));
        }

    }
}