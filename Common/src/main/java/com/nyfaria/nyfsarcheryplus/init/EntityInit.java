package com.nyfaria.nyfsarcheryplus.init;

import com.nyfaria.nyfsarcheryplus.Constants;
import com.nyfaria.nyfsarcheryplus.entity.AdvancedTippedArrowEntity;
import com.nyfaria.nyfsarcheryplus.registration.RegistrationProvider;
import com.nyfaria.nyfsarcheryplus.registration.RegistryObject;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class EntityInit {
	
	public static final RegistrationProvider<EntityType<?>> ENTITIES = RegistrationProvider.get(Registry.ENTITY_TYPE_REGISTRY, Constants.MODID);

    public static final RegistryObject<EntityType<AdvancedTippedArrowEntity>> ADVANCED_TIPPED_ARROW_ENTITY =
			ENTITIES.register("arrow", () -> EntityType.Builder.<AdvancedTippedArrowEntity>of(AdvancedTippedArrowEntity::new, MobCategory.MISC)
					.sized(0.5f, 0.5f).build("arrow"));

	public static void loadClass() {
	}
}