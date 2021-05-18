package com.nyfaria.nyfsarcheryplus;

import com.nyfaria.nyfsarcheryplus.entities.DiamondTippedArrowEntity;
import com.nyfaria.nyfsarcheryplus.entities.GoldTippedArrowEntity;
import com.nyfaria.nyfsarcheryplus.entities.IronTippedArrowEntity;
import com.nyfaria.nyfsarcheryplus.entities.NetheriteTippedArrowEntity;
import com.nyfaria.nyfsarcheryplus.entities.StoneTippedArrowEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityInit {
	
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, NyfsArcheryPlus.MOD_ID);
    private static final String STONE_ARROW_LOCATION = "stone_tipped_arrow_entity";
    private static final String GOLD_ARROW_LOCATION = "gold_tipped_arrow_entity";
    private static final String IRON_ARROW_LOCATION = "iron_tipped_arrow_entity";
    private static final String DIAMOND_ARROW_LOCATION = "diamond_tipped_arrow_entity";
    private static final String NETHERITE_ARROW_LOCATION = "netherite_tipped_arrow_entity";
	public static final EntityType<StoneTippedArrowEntity> STA_ENTITYTYPE = EntityType.Builder.<StoneTippedArrowEntity>of(StoneTippedArrowEntity::new, EntityClassification.MISC)
	 		.sized(0.5f, 0.5f).build(STONE_ARROW_LOCATION);
    public static final RegistryObject<EntityType<StoneTippedArrowEntity>> STONE_TIPPED_ARROW_ENTITY = 
			ENTITIES.register("stone_tipped_arrow_entity", () -> STA_ENTITYTYPE);
    
	public static final EntityType<GoldTippedArrowEntity> GTA_ENTITYTYPE = EntityType.Builder.<GoldTippedArrowEntity>of(GoldTippedArrowEntity::new, EntityClassification.MISC)
	 		.sized(0.5f, 0.5f).build(GOLD_ARROW_LOCATION);
    public static final RegistryObject<EntityType<GoldTippedArrowEntity>> GOLD_TIPPED_ARROW_ENTITY = 
			ENTITIES.register("gold_tipped_arrow_entity", () -> GTA_ENTITYTYPE);
    
	public static final EntityType<IronTippedArrowEntity> ITA_ENTITYTYPE = EntityType.Builder.<IronTippedArrowEntity>of(IronTippedArrowEntity::new, EntityClassification.MISC)
	 		.sized(0.5f, 0.5f).build(IRON_ARROW_LOCATION);
    public static final RegistryObject<EntityType<IronTippedArrowEntity>> IRON_TIPPED_ARROW_ENTITY = 
			ENTITIES.register("iron_tipped_arrow_entity", () -> ITA_ENTITYTYPE);
    
	public static final EntityType<DiamondTippedArrowEntity> DTA_ENTITYTYPE = EntityType.Builder.<DiamondTippedArrowEntity>of(DiamondTippedArrowEntity::new, EntityClassification.MISC)
	 		.sized(0.5f, 0.5f).build(DIAMOND_ARROW_LOCATION);
    public static final RegistryObject<EntityType<DiamondTippedArrowEntity>> DIAMOND_TIPPED_ARROW_ENTITY = 
			ENTITIES.register("diamond_tipped_arrow_entity", () -> DTA_ENTITYTYPE);
    
	public static final EntityType<NetheriteTippedArrowEntity> NTA_ENTITYTYPE = EntityType.Builder.<NetheriteTippedArrowEntity>of(NetheriteTippedArrowEntity::new, EntityClassification.MISC)
	 		.sized(0.5f, 0.5f).build(NETHERITE_ARROW_LOCATION);
    public static final RegistryObject<EntityType<NetheriteTippedArrowEntity>> NETHERITE_TIPPED_ARROW_ENTITY = 
			ENTITIES.register("netherite_tipped_arrow_entity", () -> NTA_ENTITYTYPE);
	
}
