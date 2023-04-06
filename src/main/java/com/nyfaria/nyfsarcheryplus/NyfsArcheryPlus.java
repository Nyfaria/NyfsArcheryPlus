package com.nyfaria.nyfsarcheryplus;

import com.nyfaria.nyfsarcheryplus.datagen.ModBlockStateProvider;
import com.nyfaria.nyfsarcheryplus.datagen.ModItemModelProvider;
import com.nyfaria.nyfsarcheryplus.datagen.ModLangProvider;
import com.nyfaria.nyfsarcheryplus.datagen.ModLootTableProvider;
import com.nyfaria.nyfsarcheryplus.datagen.ModRecipeProvider;
import com.nyfaria.nyfsarcheryplus.datagen.ModSoundProvider;
import com.nyfaria.nyfsarcheryplus.init.EntityInit;
import com.nyfaria.nyfsarcheryplus.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(NyfsArcheryPlus.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NyfsArcheryPlus {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "nyfsarcheryplus";


    public NyfsArcheryPlus() {

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);

        ItemInit.ITEMS.register(bus);
        EntityInit.ENTITIES.register(bus);
    }

    public void setup(final FMLCommonSetupEvent event) {
        ItemInit.preInit();
    }

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        boolean includeServer = event.includeServer();
        boolean includeClient = event.includeClient();

        generator.addProvider(includeServer, new ModRecipeProvider(generator));
        generator.addProvider(includeServer, new ModLootTableProvider(generator));
        generator.addProvider(includeServer, new ModSoundProvider(generator, existingFileHelper));

        generator.addProvider(includeClient, new ModItemModelProvider(generator, existingFileHelper));
        generator.addProvider(includeClient, new ModBlockStateProvider(generator, existingFileHelper));
        generator.addProvider(includeClient, new ModLangProvider(generator));

    }
}
