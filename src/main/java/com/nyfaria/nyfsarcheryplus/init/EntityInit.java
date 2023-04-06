package com.nyfaria.nyfsarcheryplus.init;

import com.nyfaria.nyfsarcheryplus.NyfsArcheryPlus;
import com.nyfaria.nyfsarcheryplus.entities.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
	
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, NyfsArcheryPlus.MODID);

    public static final RegistryObject<EntityType<AdvancedTippedArrowEntity>> ADVANCED_TIPPED_ARROW_ENTITY =
			ENTITIES.register("arrow", () -> EntityType.Builder.<AdvancedTippedArrowEntity>of(AdvancedTippedArrowEntity::new, MobCategory.MISC)
					.sized(0.5f, 0.5f).build("arrow"));
}
