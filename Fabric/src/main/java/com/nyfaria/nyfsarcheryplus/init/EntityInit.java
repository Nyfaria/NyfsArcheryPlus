package com.nyfaria.nyfsarcheryplus.init;

import com.nyfaria.nyfsarcheryplus.Constants;
import com.nyfaria.nyfsarcheryplus.entity.AdvancedTippedArrowEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class EntityInit {

    public static final EntityType<AdvancedTippedArrowEntity> ADVANCED_TIPPED_ARROW_ENTITY =
			Registry.register(BuiltInRegistries.ENTITY_TYPE,new ResourceLocation(Constants.MODID, "arrow"),
					FabricEntityTypeBuilder.<AdvancedTippedArrowEntity>create(MobCategory.MISC,AdvancedTippedArrowEntity::new)
							.dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());

	public static void init(){}
}