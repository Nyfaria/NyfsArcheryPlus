package com.nyfaria.nyfsarcheryplus;

import com.nyfaria.nyfsarcheryplus.init.CommonInit;
import com.nyfaria.nyfsarcheryplus.init.EntityInit;
import com.nyfaria.nyfsarcheryplus.init.ItemInit;
import net.fabricmc.api.ModInitializer;

public class NyfsArcheryPlusFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        
        // This method is invoked by the Fabric mod loader when it is ready
        // to load your mod. You can access Fabric and Common code in this
        // project.

        // Use Fabric to bootstrap the Common mod.
        Constants.LOG.info("Hello Fabric world!");
        CommonClass.init();
        CommonInit.preInit();
        EntityInit.init();
        ItemInit.init();
    }
}
