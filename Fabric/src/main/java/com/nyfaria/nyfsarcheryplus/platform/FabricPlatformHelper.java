package com.nyfaria.nyfsarcheryplus.platform;

import com.nyfaria.nyfsarcheryplus.entity.AdvancedTippedArrowEntity;
import com.nyfaria.nyfsarcheryplus.enums.ArcheryTiers;
import com.nyfaria.nyfsarcheryplus.interfaces.IArcherCollection;
import com.nyfaria.nyfsarcheryplus.platform.services.IPlatformHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;

public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public EntityType<AdvancedTippedArrowEntity> getAdvancedTippedArrowEntity() {
        return null;
    }

    @Override
    public Item getCommonTippedArrow(ArcheryTiers tier) {
        return null;
    }

    @Override
    public IArcherCollection getArcherCollection(ArcheryTiers tier) {
        return null;
    }
}
