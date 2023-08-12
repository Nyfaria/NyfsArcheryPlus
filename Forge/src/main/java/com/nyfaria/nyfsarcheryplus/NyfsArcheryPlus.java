package com.nyfaria.nyfsarcheryplus;

import com.nyfaria.nyfsarcheryplus.datagen.ModItemModelProvider;
import com.nyfaria.nyfsarcheryplus.datagen.ModLangProvider;
import com.nyfaria.nyfsarcheryplus.datagen.ModRecipeProvider;
import com.nyfaria.nyfsarcheryplus.init.CommonInit;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
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
    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        boolean includeServer = event.includeServer();
        boolean includeClient = event.includeClient();

        generator.addProvider(includeServer, new ModRecipeProvider(generator));
        generator.addProvider(includeClient, new ModLangProvider(generator));
        generator.addProvider(includeServer, new ModItemModelProvider(generator, event.getExistingFileHelper()));

    }
}