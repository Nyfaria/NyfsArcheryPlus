package com.nyfaria.nyfsarcheryplus.entity;

import com.nyfaria.nyfsarcheryplus.enums.ArcheryTiers;
import com.nyfaria.nyfsarcheryplus.platform.Services;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;

public class AdvancedTippedArrowEntity extends AbstractArrow {

	private static final EntityDataAccessor<String> tierData = SynchedEntityData.defineId(AdvancedTippedArrowEntity.class, EntityDataSerializers.STRING);

	private ArcheryTiers tier;
	public AdvancedTippedArrowEntity(Level world, LivingEntity player, ArcheryTiers tier) {
		this(Services.PLATFORM.getAdvancedTippedArrowEntity(), player, world);
		this.tier = tier;
		this.setBaseDamage(tier.getDamage());
		this.setTierData(tier);
	}

	public AdvancedTippedArrowEntity(EntityType typeIn, LivingEntity player, Level world) {
		super(typeIn, player, world);
	}


	public AdvancedTippedArrowEntity(EntityType<AdvancedTippedArrowEntity> entity, Level level) {
		super(entity, level);
	}

	public AdvancedTippedArrowEntity(double x, double y, double z, Level level, ArcheryTiers tier) {
		super(Services.PLATFORM.getAdvancedTippedArrowEntity(), x, y, z, level);
		this.tier = tier;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putString("tier", tier.name());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag $$0) {
		super.readAdditionalSaveData($$0);
		tier = ArcheryTiers.getByName($$0.getString("tier"));
		setTierData(tier);
	}

	@Override
	public double getBaseDamage() {
		return tier.getDamage();
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(tierData, "stone");
	}

	@Override
	protected ItemStack getPickupItem() {
		return new ItemStack(getArrowByTier(tier));
	}

	private ItemLike getArrowByTier(ArcheryTiers tier) {
		return Services.PLATFORM.getCommonTippedArrow(tier);
	}

	private void setTierData(ArcheryTiers tier) {
		this.entityData.set(tierData, tier.getName());
	}

	public ArcheryTiers getTier() {
		return tier;
	}



	@Override
	public void onSyncedDataUpdated(EntityDataAccessor<?> $$0) {
		super.onSyncedDataUpdated($$0);
		if(tierData.equals($$0)) {
			this.tier = ArcheryTiers.getByName(this.entityData.get(tierData));
		}
	}
}