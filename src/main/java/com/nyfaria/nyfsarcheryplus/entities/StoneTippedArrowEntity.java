package com.nyfaria.nyfsarcheryplus.entities;

import com.nyfaria.nyfsarcheryplus.ItemInit;
import com.nyfaria.nyfsarcheryplus.items.StoneTippedArrowItem;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemGroup;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.protocol.Packet;
import net.minecraft.potion.Potions;
import net.minecraft.util.IItemProvider;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.network.NetworkHooks;

public class StoneTippedArrowEntity extends AbstractArrow {

	public StoneTippedArrowEntity(Level world, LivingEntity player) {
		super(EntityType.ARROW, player, world);
		this.setBaseDamage(3);
		
	}
    public StoneTippedArrowEntity(final EntityType<? extends StoneTippedArrowEntity> p_i50172_1_, final Level p_i50172_2_) {
        super(p_i50172_1_, p_i50172_2_);
		this.setBaseDamage(3);
    }
    
    public StoneTippedArrowEntity(final Level worldIn, final double x, final double y, final double z) {
        super(EntityType.ARROW, x, y, z, worldIn);
		this.setBaseDamage(3);
        
    }
	public StoneTippedArrowEntity(EntityType typeIn, LivingEntity player, Level world) {
		super(typeIn, player, world);
		this.setBaseDamage(3);
	}
	
    public StoneTippedArrowEntity(EntityType<? extends AbstractArrow> stoneTippedArrowItem, Level worldIn, double x, double y,
			double z) {
        super(stoneTippedArrowItem, x, y, z, worldIn);
		this.setBaseDamage(3);
	}
	@Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

	
	@Override
	protected ItemStack getPickupItem() {
		return new ItemStack(ItemInit.STONE_TIPPED_ARROW_ITEM);
	}
}
