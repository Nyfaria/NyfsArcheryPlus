package com.nyfaria.nyfsarcheryplus;

import com.nyfaria.nyfsarcheryplus.entities.DiamondTippedArrowEntity;
import com.nyfaria.nyfsarcheryplus.entities.GoldTippedArrowEntity;
import com.nyfaria.nyfsarcheryplus.entities.IronTippedArrowEntity;
import com.nyfaria.nyfsarcheryplus.entities.NetheriteTippedArrowEntity;
import com.nyfaria.nyfsarcheryplus.entities.StoneTippedArrowEntity;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
	
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, NyfsArcheryPlus.MODID);

    private static final String STONE_ARROW_LOCATION = "stone_tipped_arrow_entity";
    private static final String GOLD_ARROW_LOCATION = "gold_tipped_arrow_entity";
    private static final String IRON_ARROW_LOCATION = "iron_tipped_arrow_entity";
    private static final String DIAMOND_ARROW_LOCATION = "diamond_tipped_arrow_entity";
    private static final String NETHERITE_ARROW_LOCATION = "netherite_tipped_arrow_entity";

    public static final RegistryObject<EntityType<StoneTippedArrowEntity>> STONE_TIPPED_ARROW_ENTITY =
			ENTITIES.register("stone_tipped_arrow_entity", () -> EntityType.Builder.<StoneTippedArrowEntity>of(StoneTippedArrowEntity::new, MobCategory.MISC)
					.sized(0.5f, 0.5f).build(STONE_ARROW_LOCATION));

    public static final RegistryObject<EntityType<GoldTippedArrowEntity>> GOLD_TIPPED_ARROW_ENTITY =
			ENTITIES.register("gold_tipped_arrow_entity", () -> EntityType.Builder.<GoldTippedArrowEntity>of(GoldTippedArrowEntity::new, MobCategory.MISC)
					.sized(0.5f, 0.5f).build(GOLD_ARROW_LOCATION));

    public static final RegistryObject<EntityType<IronTippedArrowEntity>> IRON_TIPPED_ARROW_ENTITY =
			ENTITIES.register("iron_tipped_arrow_entity", () -> EntityType.Builder.<IronTippedArrowEntity>of(IronTippedArrowEntity::new, MobCategory.MISC)
					.sized(0.5f, 0.5f).build(IRON_ARROW_LOCATION));

    public static final RegistryObject<EntityType<DiamondTippedArrowEntity>> DIAMOND_TIPPED_ARROW_ENTITY =
			ENTITIES.register("diamond_tipped_arrow_entity", () -> EntityType.Builder.<DiamondTippedArrowEntity>of(DiamondTippedArrowEntity::new, MobCategory.MISC)
					.sized(0.5f, 0.5f).build(DIAMOND_ARROW_LOCATION));

    public static final RegistryObject<EntityType<NetheriteTippedArrowEntity>> NETHERITE_TIPPED_ARROW_ENTITY =
			ENTITIES.register("netherite_tipped_arrow_entity", () -> EntityType.Builder.<NetheriteTippedArrowEntity>of(NetheriteTippedArrowEntity::new, MobCategory.MISC)
					.sized(0.5f, 0.5f).build(NETHERITE_ARROW_LOCATION));
	
}
