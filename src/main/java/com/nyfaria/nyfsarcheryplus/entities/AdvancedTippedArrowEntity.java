package com.nyfaria.nyfsarcheryplus.entities;

import com.nyfaria.nyfsarcheryplus.enums.ArcheryTiers;
import com.nyfaria.nyfsarcheryplus.init.EntityInit;
import com.nyfaria.nyfsarcheryplus.init.ItemInit;
import com.nyfaria.nyfsarcheryplus.items.AdvancedTippedArrowItem;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

public class AdvancedTippedArrowEntity extends AbstractArrow {

	private ArcheryTiers tier;
	public AdvancedTippedArrowEntity(Level world, LivingEntity player, ArcheryTiers tier) {
		this(EntityInit.ADVANCED_TIPPED_ARROW_ENTITY.get(), player, world);
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
		super(EntityInit.ADVANCED_TIPPED_ARROW_ENTITY.get(), x, y, z, level);
		this.tier = tier;
	}

	@Override
	public double getBaseDamage() {
		return tier.getDamage();
	}
	@Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

	
	@Override
	protected ItemStack getPickupItem() {
		return new ItemStack(getArrowByTier(tier));
	}

	private ItemLike getArrowByTier(ArcheryTiers tier) {
		return switch(tier) {
			case STONE -> ItemInit.STONE_COLLECTION.getTippedArrow();
			case IRON -> ItemInit.IRON_COLLECTION.getTippedArrow();
			case GOLD -> ItemInit.GOLD_COLLECTION.getTippedArrow();
			case DIAMOND -> ItemInit.DIAMOND_COLLECTION.getTippedArrow();
			case NETHERITE -> ItemInit.NETHERITE_COLLECTION.getTippedArrow();
		};
	}

	public ArcheryTiers getTier() {
		return tier;
	}

	public void setTier(ArcheryTiers tier) {
		this.tier = tier;
	}
}
