package com.nyfaria.nyfsarcheryplus;

import com.nyfaria.nyfsarcheryplus.entities.DiamondTippedArrowEntity;
import com.nyfaria.nyfsarcheryplus.entities.GoldTippedArrowEntity;
import com.nyfaria.nyfsarcheryplus.entities.IronTippedArrowEntity;
import com.nyfaria.nyfsarcheryplus.entities.NetheriteTippedArrowEntity;
import com.nyfaria.nyfsarcheryplus.entities.StoneTippedArrowEntity;
import com.nyfaria.nyfsarcheryplus.items.DiamondArrowTipItem;
import com.nyfaria.nyfsarcheryplus.items.DiamondBowItem;
import com.nyfaria.nyfsarcheryplus.items.GoldArrowTipItem;
import com.nyfaria.nyfsarcheryplus.items.GoldBowItem;
import com.nyfaria.nyfsarcheryplus.items.GoldTippedArrowItem;
import com.nyfaria.nyfsarcheryplus.items.IronArrowTipItem;
import com.nyfaria.nyfsarcheryplus.items.IronBowItem;
import com.nyfaria.nyfsarcheryplus.items.IronTippedArrowItem;
import com.nyfaria.nyfsarcheryplus.items.NetheriteArrowTipItem;
import com.nyfaria.nyfsarcheryplus.items.NetheriteBowItem;
import com.nyfaria.nyfsarcheryplus.items.NetheriteTippedArrowItem;
import com.nyfaria.nyfsarcheryplus.items.StoneArrowTipItem;
import com.nyfaria.nyfsarcheryplus.items.StoneTippedArrowItem;
import com.nyfaria.nyfsarcheryplus.items.DiamondTippedArrowItem;

import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.IPosition;
import net.minecraft.dispenser.ProjectileDispenseBehavior;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NyfsArcheryPlus.MOD_ID);

    public static final StoneTippedArrowItem STONE_TIPPED_ARROW_ITEM = new StoneTippedArrowItem(new Item.Properties().stacksTo(64).tab(ItemGroup.TAB_COMBAT));
    public static final GoldTippedArrowItem GOLD_TIPPED_ARROW_ITEM = new GoldTippedArrowItem(new Item.Properties().stacksTo(64).tab(ItemGroup.TAB_COMBAT));
    public static final IronTippedArrowItem IRON_TIPPED_ARROW_ITEM = new IronTippedArrowItem(new Item.Properties().stacksTo(64).tab(ItemGroup.TAB_COMBAT));
    public static final DiamondTippedArrowItem DIAMOND_TIPPED_ARROW_ITEM = new DiamondTippedArrowItem(new Item.Properties().stacksTo(64).tab(ItemGroup.TAB_COMBAT));
    public static final NetheriteTippedArrowItem NETHERITE_TIPPED_ARROW_ITEM = new NetheriteTippedArrowItem(new Item.Properties().stacksTo(64).tab(ItemGroup.TAB_COMBAT));
	public static final RegistryObject<IronBowItem> IRON_BOW = ITEMS.register("iron_bow", () -> new IronBowItem(new Item.Properties()));
	public static final RegistryObject<GoldBowItem> GOLD_BOW = ITEMS.register("gold_bow", () -> new GoldBowItem(new Item.Properties()));
	public static final RegistryObject<DiamondBowItem> DIAMOND_BOW = ITEMS.register("diamond_bow", () -> new DiamondBowItem(new Item.Properties()));
	public static final RegistryObject<NetheriteBowItem> NETHERITE_BOW = ITEMS.register("netherite_bow", () -> new NetheriteBowItem(new Item.Properties()));
	public static final RegistryObject<StoneArrowTipItem> STONE_ARROW_TIP = ITEMS.register("stone_arrow_tip", () -> new StoneArrowTipItem(new Item.Properties().stacksTo(64).tab(ItemGroup.TAB_COMBAT)));
	public static final RegistryObject<StoneTippedArrowItem> STONE_TIPPED_ARROW = ITEMS.register("stone_tipped_arrow", () -> STONE_TIPPED_ARROW_ITEM);
	public static final RegistryObject<GoldArrowTipItem> GOLD_ARROW_TIP = ITEMS.register("gold_arrow_tip", () -> new GoldArrowTipItem(new Item.Properties().stacksTo(64).tab(ItemGroup.TAB_COMBAT)));
	public static final RegistryObject<GoldTippedArrowItem> GOLD_TIPPED_ARROW = ITEMS.register("gold_tipped_arrow", () -> GOLD_TIPPED_ARROW_ITEM);
	public static final RegistryObject<IronArrowTipItem> IRON_ARROW_TIP = ITEMS.register("iron_arrow_tip", () -> new IronArrowTipItem(new Item.Properties().stacksTo(64).tab(ItemGroup.TAB_COMBAT)));
	public static final RegistryObject<IronTippedArrowItem> IRON_TIPPED_ARROW = ITEMS.register("iron_tipped_arrow", () -> IRON_TIPPED_ARROW_ITEM);
	public static final RegistryObject<DiamondArrowTipItem> DIAMOND_ARROW_TIP = ITEMS.register("diamond_arrow_tip", () -> new DiamondArrowTipItem(new Item.Properties().stacksTo(64).tab(ItemGroup.TAB_COMBAT)));
	public static final RegistryObject<DiamondTippedArrowItem> DIAMOND_TIPPED_ARROW = ITEMS.register("diamond_tipped_arrow", () -> DIAMOND_TIPPED_ARROW_ITEM);
	public static final RegistryObject<NetheriteArrowTipItem> NETHERITE_ARROW_TIP = ITEMS.register("netherite_arrow_tip", () -> new NetheriteArrowTipItem(new Item.Properties().stacksTo(64).tab(ItemGroup.TAB_COMBAT)));
	public static final RegistryObject<NetheriteTippedArrowItem> NETHERITE_TIPPED_ARROW = ITEMS.register("netherite_tipped_arrow", () -> NETHERITE_TIPPED_ARROW_ITEM);
	
	
	public static void preInit() {
		DispenserBlock.registerBehavior(STONE_TIPPED_ARROW_ITEM, new ProjectileDispenseBehavior() 
		{

			@Override
			protected ProjectileEntity getProjectile(World worldIn, IPosition position, ItemStack stackIn) {
				StoneTippedArrowEntity entityArrow = new StoneTippedArrowEntity(EntityInit.STA_ENTITYTYPE, worldIn, position.x(), position.y(), position.z());
				entityArrow.pickup = AbstractArrowEntity.PickupStatus.ALLOWED;
				return entityArrow;
			}
			
		});
		DispenserBlock.registerBehavior(IRON_TIPPED_ARROW_ITEM, new ProjectileDispenseBehavior() 
		{

			@Override
			protected ProjectileEntity getProjectile(World worldIn, IPosition position, ItemStack stackIn) {
				IronTippedArrowEntity entityArrow = new IronTippedArrowEntity(EntityInit.ITA_ENTITYTYPE, worldIn, position.x(), position.y(), position.z());
				entityArrow.pickup = AbstractArrowEntity.PickupStatus.ALLOWED;
				return entityArrow;
			}
			
		});
		DispenserBlock.registerBehavior(GOLD_TIPPED_ARROW_ITEM, new ProjectileDispenseBehavior() 
		{

			@Override
			protected ProjectileEntity getProjectile(World worldIn, IPosition position, ItemStack stackIn) {
				GoldTippedArrowEntity entityArrow = new GoldTippedArrowEntity(EntityInit.GTA_ENTITYTYPE, worldIn, position.x(), position.y(), position.z());
				entityArrow.pickup = AbstractArrowEntity.PickupStatus.ALLOWED;
				return entityArrow;
			}
			
		});
		DispenserBlock.registerBehavior(DIAMOND_TIPPED_ARROW_ITEM, new ProjectileDispenseBehavior() 
		{

			@Override
			protected ProjectileEntity getProjectile(World worldIn, IPosition position, ItemStack stackIn) {
				DiamondTippedArrowEntity entityArrow = new DiamondTippedArrowEntity(EntityInit.DTA_ENTITYTYPE, worldIn, position.x(), position.y(), position.z());
				entityArrow.pickup = AbstractArrowEntity.PickupStatus.ALLOWED;
				return entityArrow;
			}
			
		});
		DispenserBlock.registerBehavior(NETHERITE_TIPPED_ARROW_ITEM, new ProjectileDispenseBehavior() 
		{

			@Override
			protected ProjectileEntity getProjectile(World worldIn, IPosition position, ItemStack stackIn) {
				NetheriteTippedArrowEntity entityArrow = new NetheriteTippedArrowEntity(EntityInit.NTA_ENTITYTYPE, worldIn, position.x(), position.y(), position.z());
				entityArrow.pickup = AbstractArrowEntity.PickupStatus.ALLOWED;
				return entityArrow;
			}
			
		});
		
	}

}
