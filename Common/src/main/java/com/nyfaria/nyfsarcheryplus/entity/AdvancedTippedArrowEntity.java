package com.nyfaria.nyfsarcheryplus.entity;

import com.nyfaria.nyfsarcheryplus.enums.ArcheryTiers;
import com.nyfaria.nyfsarcheryplus.platform.Services;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;

public class AdvancedTippedArrowEntity extends AbstractArrow {

	private ArcheryTiers tier;
	public AdvancedTippedArrowEntity(Level world, LivingEntity player, ArcheryTiers tier) {
		this(Services.PLATFORM.getAdvancedTippedArrowEntity(), player, world);
		this.tier = tier;
	}

	public AdvancedTippedArrowEntity(EntityType typeIn, LivingEntity player, Level world) {
		super(typeIn, player, world);
		this.tier = ArcheryTiers.STONE;
	}


	public AdvancedTippedArrowEntity(EntityType<AdvancedTippedArrowEntity> entity, Level level) {
		super(entity, level);
		this.tier = ArcheryTiers.STONE;
	}

	public AdvancedTippedArrowEntity(double x, double y, double z, Level level, ArcheryTiers tier) {
		super(Services.PLATFORM.getAdvancedTippedArrowEntity(), x, y, z, level);
		this.tier = tier;
	}

	@Override
	public double getBaseDamage() {
		return tier.getDamage();
	}

	
	@Override
	protected ItemStack getPickupItem() {
		return new ItemStack(getArrowByTier(tier));
	}

	private ItemLike getArrowByTier(ArcheryTiers tier) {
		return Services.PLATFORM.getCommonTippedArrow(tier);
	}

	public ArcheryTiers getTier() {
		return tier;
	}

	public void setTier(ArcheryTiers tier) {
		this.tier = tier;
	}
}