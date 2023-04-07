package com.nyfaria.nyfsarcheryplus;

import com.nyfaria.nyfsarcheryplus.init.CommonClientInit;
import net.fabricmc.api.ClientModInitializer;

public class NyfsArcheryPlusFabricClient implements ClientModInitializer {
    
    @Override
    public void onInitializeClient() {
        CommonClientInit.clientSetup();
    }
}
