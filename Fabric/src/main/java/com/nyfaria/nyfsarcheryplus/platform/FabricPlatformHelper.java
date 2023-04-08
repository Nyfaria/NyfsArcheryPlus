package com.nyfaria.nyfsarcheryplus.platform;

import com.nyfaria.nyfsarcheryplus.entity.AdvancedTippedArrowEntity;
import com.nyfaria.nyfsarcheryplus.enums.ArcheryTiers;
import com.nyfaria.nyfsarcheryplus.init.EntityInit;
import com.nyfaria.nyfsarcheryplus.init.ItemInit;
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
        return EntityInit.ADVANCED_TIPPED_ARROW_ENTITY;
    }

    @Override
    public Item getCommonTippedArrow(ArcheryTiers tier) {
        return switch (tier) {
            case STONE -> ItemInit.STONE_COLLECTION.getTippedArrow();
            case IRON -> ItemInit.IRON_COLLECTION.getTippedArrow();
            case GOLD -> ItemInit.GOLD_COLLECTION.getTippedArrow();
            case DIAMOND -> ItemInit.DIAMOND_COLLECTION.getTippedArrow();
            case NETHERITE -> ItemInit.NETHERITE_COLLECTION.getTippedArrow();
        };
    }

    @Override
    public IArcherCollection getArcherCollection(ArcheryTiers tier) {
        return switch (tier) {
            case STONE -> ItemInit.STONE_COLLECTION;
            case IRON -> ItemInit.IRON_COLLECTION;
            case GOLD -> ItemInit.GOLD_COLLECTION;
            case DIAMOND -> ItemInit.DIAMOND_COLLECTION;
            case NETHERITE -> ItemInit.NETHERITE_COLLECTION;
        };
    }
}