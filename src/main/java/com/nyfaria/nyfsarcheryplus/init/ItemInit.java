package com.nyfaria.nyfsarcheryplus.init;

import com.nyfaria.nyfsarcheryplus.NyfsArcheryPlus;
import com.nyfaria.nyfsarcheryplus.entities.*;
import com.nyfaria.nyfsarcheryplus.enums.ArcheryTiers;
import com.nyfaria.nyfsarcheryplus.init.EntityInit;
import com.nyfaria.nyfsarcheryplus.items.*;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NyfsArcheryPlus.MODID);

	public static final ArcheryCollection<Item> NETHERITE_COLLECTION = ArcheryCollection.registerCollection(ArcheryTiers.NETHERITE);
	public static final ArcheryCollection<Item> DIAMOND_COLLECTION = ArcheryCollection.registerCollection(ArcheryTiers.DIAMOND);
	public static final ArcheryCollection<Item> GOLD_COLLECTION = ArcheryCollection.registerCollection(ArcheryTiers.GOLD);
	public static final ArcheryCollection<Item> IRON_COLLECTION = ArcheryCollection.registerCollection(ArcheryTiers.IRON);
	public static final ArcheryCollection<Item> STONE_COLLECTION = new ArcheryCollection<>(ArcheryTiers.STONE,null,null, ITEMS.register("stone_arrowhead", () -> new Item(new Item.Properties().stacksTo(64).tab(CreativeModeTab.TAB_COMBAT))),ITEMS.register("stone_tipped_arrow", () -> new AdvancedTippedArrowItem(new Item.Properties(),ArcheryTiers.STONE)));
    
//	public static final RegistryObject<Item> IRON_BOW = ITEMS.register("iron_bow", () -> new AdvancedBowItem(new Item.Properties(), ArcheryTiers.IRON));
//	public static final RegistryObject<Item> GOLD_BOW = ITEMS.register("gold_bow", () -> new AdvancedBowItem(new Item.Properties(), ArcheryTiers.GOLD));
//	public static final RegistryObject<Item> DIAMOND_BOW = ITEMS.register("diamond_bow", () -> new AdvancedBowItem(new Item.Properties(), ArcheryTiers.DIAMOND));
//	public static final RegistryObject<Item> NETHERITE_BOW = ITEMS.register("netherite_bow", () -> new AdvancedBowItem(new Item.Properties().fireResistant(), ArcheryTiers.NETHERITE));

//	public static final RegistryObject<Item> STONE_ARROW_TIP = ITEMS.register("stone_arrow_tip", () -> new Item(new Item.Properties().stacksTo(64).tab(CreativeModeTab.TAB_COMBAT)));
//	public static final RegistryObject<Item> GOLD_ARROW_TIP = ITEMS.register("gold_arrow_tip", () -> new Item(new Item.Properties().stacksTo(64).tab(CreativeModeTab.TAB_COMBAT)));
//	public static final RegistryObject<Item> IRON_ARROW_TIP = ITEMS.register("iron_arrow_tip", () -> new Item(new Item.Properties().stacksTo(64).tab(CreativeModeTab.TAB_COMBAT)));
//	public static final RegistryObject<Item> DIAMOND_ARROW_TIP = ITEMS.register("diamond_arrow_tip", () -> new Item(new Item.Properties().stacksTo(64).tab(CreativeModeTab.TAB_COMBAT)));
//	public static final RegistryObject<Item> NETHERITE_ARROW_TIP = ITEMS.register("netherite_arrow_tip", () -> new Item(new Item.Properties().stacksTo(64).tab(CreativeModeTab.TAB_COMBAT)));

//	public static final RegistryObject<Item> STONE_TIPPED_ARROW = ITEMS.register("stone_tipped_arrow", () -> new AdvancedTippedArrowItem(new Item.Properties().stacksTo(64).tab(CreativeModeTab.TAB_COMBAT),ArcheryTiers.STONE));
//	public static final RegistryObject<Item> IRON_TIPPED_ARROW = ITEMS.register("iron_tipped_arrow", () -> new AdvancedTippedArrowItem(new Item.Properties().stacksTo(64).tab(CreativeModeTab.TAB_COMBAT),ArcheryTiers.IRON));
//	public static final RegistryObject<Item> GOLD_TIPPED_ARROW = ITEMS.register("gold_tipped_arrow", () -> new AdvancedTippedArrowItem(new Item.Properties().stacksTo(64).tab(CreativeModeTab.TAB_COMBAT),ArcheryTiers.GOLD));
//	public static final RegistryObject<Item> DIAMOND_TIPPED_ARROW = ITEMS.register("diamond_tipped_arrow", () -> new AdvancedTippedArrowItem(new Item.Properties().stacksTo(64).tab(CreativeModeTab.TAB_COMBAT), ArcheryTiers.DIAMOND));
//	public static final RegistryObject<Item> NETHERITE_TIPPED_ARROW = ITEMS.register("netherite_tipped_arrow", () -> new AdvancedTippedArrowItem(new Item.Properties().stacksTo(64).tab(CreativeModeTab.TAB_COMBAT),ArcheryTiers.NETHERITE));

	
	public static void preInit() {
		DispenserBlock.registerBehavior(STONE_COLLECTION.getTippedArrow(), new AbstractProjectileDispenseBehavior()
		{

			@Override
			protected Projectile getProjectile(Level worldIn, Position position, ItemStack stackIn) {
				AdvancedTippedArrowEntity entityArrow = new AdvancedTippedArrowEntity(position.x(), position.y(), position.z(),worldIn ,ArcheryTiers.STONE);
				entityArrow.pickup = AbstractArrow.Pickup.ALLOWED;
				return entityArrow;
			}
			
		});
		DispenserBlock.registerBehavior(IRON_COLLECTION.getTippedArrow(), new AbstractProjectileDispenseBehavior()
		{

			@Override
			protected Projectile getProjectile(Level worldIn, Position position, ItemStack stackIn) {
				AdvancedTippedArrowEntity entityArrow = new AdvancedTippedArrowEntity(position.x(), position.y(), position.z(),worldIn ,ArcheryTiers.IRON);
				entityArrow.pickup = AbstractArrow.Pickup.ALLOWED;
				return entityArrow;
			}
			
		});
		DispenserBlock.registerBehavior(GOLD_COLLECTION.getTippedArrow(), new AbstractProjectileDispenseBehavior()
		{

			@Override
			protected Projectile getProjectile(Level worldIn, Position position, ItemStack stackIn) {
				AdvancedTippedArrowEntity entityArrow = new AdvancedTippedArrowEntity(position.x(), position.y(), position.z(),worldIn ,ArcheryTiers.GOLD);
				entityArrow.pickup = AbstractArrow.Pickup.ALLOWED;
				return entityArrow;
			}
			
		});
		DispenserBlock.registerBehavior(DIAMOND_COLLECTION.getTippedArrow(), new AbstractProjectileDispenseBehavior()
		{

			@Override
			protected Projectile getProjectile(Level worldIn, Position position, ItemStack stackIn) {
				AdvancedTippedArrowEntity entityArrow = new AdvancedTippedArrowEntity(position.x(), position.y(), position.z(),worldIn ,ArcheryTiers.DIAMOND);
				entityArrow.pickup = AbstractArrow.Pickup.ALLOWED;
				return entityArrow;
			}
			
		});
		DispenserBlock.registerBehavior(NETHERITE_COLLECTION.getTippedArrow(), new AbstractProjectileDispenseBehavior()
		{

			@Override
			protected Projectile getProjectile(Level worldIn, Position position, ItemStack stackIn) {
				AdvancedTippedArrowEntity entityArrow = new AdvancedTippedArrowEntity(position.x(), position.y(), position.z(),worldIn ,ArcheryTiers.NETHERITE);
				entityArrow.pickup = AbstractArrow.Pickup.ALLOWED;
				return entityArrow;
			}
			
		});
		
	}

}
