package com.nyfaria.nyfsarcheryplus.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potions;
import net.minecraft.world.World;

public class StoneTippedArrowEntity extends AbstractArrowEntity {

	public StoneTippedArrowEntity(World world, LivingEntity player) {
		super(EntityType.ARROW, player, world);
		System.out.println(this.getBaseDamage());
	}
    public StoneTippedArrowEntity(final EntityType<? extends StoneTippedArrowEntity> p_i50172_1_, final World p_i50172_2_) {
        super(p_i50172_1_, p_i50172_2_);
		System.out.println(this.getBaseDamage());
    }
    
    public StoneTippedArrowEntity(final World worldIn, final double x, final double y, final double z) {
        super(EntityType.ARROW, x, y, z, worldIn);
        
    }
	@Override
	protected ItemStack getPickupItem() {
		return null;
	}
}
