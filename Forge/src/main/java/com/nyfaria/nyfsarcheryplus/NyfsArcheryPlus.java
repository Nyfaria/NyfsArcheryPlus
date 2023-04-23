package com.nyfaria.nyfsarcheryplus;

import com.nyfaria.nyfsarcheryplus.datagen.ModItemModelProvider;
import com.nyfaria.nyfsarcheryplus.datagen.ModLangProvider;
import com.nyfaria.nyfsarcheryplus.datagen.ModRecipeProvider;
import com.nyfaria.nyfsarcheryplus.init.CommonInit;
import com.nyfaria.nyfsarcheryplus.init.EntityInit;
import com.nyfaria.nyfsarcheryplus.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
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
        PackOutput output = generator.getPackOutput();
        boolean includeServer = event.includeServer();
        boolean includeClient = event.includeClient();

        generator.addProvider(includeServer, new ModRecipeProvider(output));
        generator.addProvider(includeClient, new ModLangProvider(output));
        generator.addProvider(includeServer, new ModItemModelProvider(output, event.getExistingFileHelper()));

    }
}