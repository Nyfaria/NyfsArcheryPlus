package com.nyfaria.nyfsarcheryplus.entities;

import com.nyfaria.nyfsarcheryplus.ItemInit;
import com.nyfaria.nyfsarcheryplus.items.StoneTippedArrowItem;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.potion.Potions;
import net.minecraft.util.IItemProvider;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.network.NetworkHooks;

public class NetheriteTippedArrowEntity extends AbstractArrowEntity {

	public NetheriteTippedArrowEntity(World world, LivingEntity player) {
		super(EntityType.ARROW, player, world);
		this.setBaseDamage(7);
	}
    public NetheriteTippedArrowEntity(final EntityType<? extends NetheriteTippedArrowEntity> p_i50172_1_, final World p_i50172_2_) {
        super(p_i50172_1_, p_i50172_2_);
		this.setBaseDamage(7);
    }
    
    public NetheriteTippedArrowEntity(final World worldIn, final double x, final double y, final double z) {
        super(EntityType.ARROW, x, y, z, worldIn);
		this.setBaseDamage(7);
        
    }
	public NetheriteTippedArrowEntity(EntityType typeIn, LivingEntity player, World world) {
		super(typeIn, player, world);
		this.setBaseDamage(7);
	}
	
    public NetheriteTippedArrowEntity(EntityType<NetheriteTippedArrowEntity> ntaEntitytype, World worldIn, double x,
			double y, double z) {
        super(ntaEntitytype, x, y, z, worldIn);
		this.setBaseDamage(7);
	}
	@Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

	
	@Override
	protected ItemStack getPickupItem() {
		return new ItemStack(ItemInit.STONE_TIPPED_ARROW_ITEM);
	}
}
