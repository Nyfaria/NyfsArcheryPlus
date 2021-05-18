package com.nyfaria.nyfsarcheryplus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(NyfsArcheryPlus.MOD_ID)
public class NyfsArcheryPlus
{
    private static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "nyfsarcheryplus";

    public static CommonProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new CommonProxy()); 

    public NyfsArcheryPlus() {

    	IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    	bus.addListener(this::setup);
    	
    	ItemInit.ITEMS.register(bus);
    	ItemInit.preInit();
    	EntityInit.ENTITIES.register(bus);
    	MinecraftForge.EVENT_BUS.register(this);
    }

    public void setup(final FMLCommonSetupEvent event) {
        proxy.init();
        
    }
}
