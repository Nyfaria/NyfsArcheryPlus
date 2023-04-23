package com.nyfaria.nyfsarcheryplus;

import com.nyfaria.nyfsarcheryplus.init.CommonInit;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NyfsArcheryPlus {
    
    public NyfsArcheryPlus() {
        CommonClass.init();
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);
    }

    public void setup(final FMLCommonSetupEvent event) {
        CommonInit.preInit();
    }

}