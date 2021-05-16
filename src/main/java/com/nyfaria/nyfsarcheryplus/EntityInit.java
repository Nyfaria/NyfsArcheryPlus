package com.nyfaria.nyfsarcheryplus;

import com.nyfaria.nyfsarcheryplus.entities.StoneTippedArrowEntity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item.Properties;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityInit {
	
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, NyfsBows.MOD_ID);
    private static final String ARROW_LOCATION = "stone_tipped_arrow_entity";
	public static final RegistryObject<EntityType<StoneTippedArrowEntity>> STONE_TIPPED_ARROW_ENTITY = 
			ENTITIES.register("stone_tipped_arrow_entity", () -> 
	 		EntityType.Builder.<StoneTippedArrowEntity>of(StoneTippedArrowEntity::new, EntityClassification.MISC)
	 		.sized(0.5f, 0.5f).build(ARROW_LOCATION));
}
