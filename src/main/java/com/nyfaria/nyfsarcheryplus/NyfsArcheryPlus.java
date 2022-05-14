package com.nyfaria.nyfsarcheryplus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(NyfsArcheryPlus.MODID)
public class NyfsArcheryPlus
{
    private static final Logger LOGGER = LogManager.getLogger();
	public static final String MODID = "nyfsarcheryplus";


    public NyfsArcheryPlus() {

    	IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    	bus.addListener(this::setup);
    	
    	ItemInit.ITEMS.register(bus);
    	ItemInit.preInit();
    	EntityInit.ENTITIES.register(bus);
    }

    public void setup(final FMLCommonSetupEvent event) {
        
    }
}
