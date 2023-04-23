package com.nyfaria.nyfsarcheryplus.entity;

import com.google.common.collect.Sets;
import com.nyfaria.nyfsarcheryplus.enums.ArcheryTiers;
import com.nyfaria.nyfsarcheryplus.init.EntityInit;
import com.nyfaria.nyfsarcheryplus.init.ItemInit;
import com.nyfaria.nyfsarcheryplus.platform.Services;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;

import java.util.Collection;
import java.util.Set;

public class AdvancedTippedArrowEntity extends AbstractArrow {
	private static final int EXPOSED_POTION_DECAY_TIME = 600;
	private static final int NO_EFFECT_COLOR = -1;
	private static final EntityDataAccessor<Integer> ID_EFFECT_COLOR = SynchedEntityData.defineId(AdvancedTippedArrowEntity.class, EntityDataSerializers.INT);
	private static final byte EVENT_POTION_PUFF = 0;
	private Potion potion = Potions.EMPTY;
	private final Set<MobEffectInstance> effects = Sets.newHashSet();
	private boolean fixedColor;

	private static final EntityDataAccessor<String> tierData = SynchedEntityData.defineId(AdvancedTippedArrowEntity.class, EntityDataSerializers.STRING);

	private ArcheryTiers tier;

	public AdvancedTippedArrowEntity(Level world, LivingEntity player, ArcheryTiers tier) {
		this(EntityInit.ADVANCED_TIPPED_ARROW_ENTITY.get(), player, world);
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
		super(EntityInit.ADVANCED_TIPPED_ARROW_ENTITY.get(), x, y, z, level);
		this.tier = tier;
		this.setTierData(tier);
	}

	public void setEffectsFromItem(ItemStack p_36879_) {
		if (p_36879_.hasTag()) {
			this.potion = PotionUtils.getPotion(p_36879_);
			Collection<MobEffectInstance> collection = PotionUtils.getCustomEffects(p_36879_);
			if (!collection.isEmpty()) {
				for(MobEffectInstance mobeffectinstance : collection) {
					this.effects.add(new MobEffectInstance(mobeffectinstance));
				}
			}

			int i = getCustomColor(p_36879_);
			if (i == -1) {
				this.updateColor();
			} else {
				this.setFixedColor(i);
			}
		} else {
			this.potion = Potions.EMPTY;
			this.effects.clear();
			this.entityData.set(ID_EFFECT_COLOR, -1);
		}

	}

	public static int getCustomColor(ItemStack p_36885_) {
		CompoundTag compoundtag = p_36885_.getTag();
		return compoundtag != null && compoundtag.contains("CustomPotionColor", 99) ? compoundtag.getInt("CustomPotionColor") : -1;
	}

	private void updateColor() {
		this.fixedColor = false;
		if (this.potion == Potions.EMPTY && this.effects.isEmpty()) {
			this.entityData.set(ID_EFFECT_COLOR, -1);
		} else {
			this.entityData.set(ID_EFFECT_COLOR, PotionUtils.getColor(PotionUtils.getAllEffects(this.potion, this.effects)));
		}

	}

	public void addEffect(MobEffectInstance p_36871_) {
		this.effects.add(p_36871_);
		this.getEntityData().set(ID_EFFECT_COLOR, PotionUtils.getColor(PotionUtils.getAllEffects(this.potion, this.effects)));
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putString("tier", tier.name());
		if (this.potion != Potions.EMPTY) {
			tag.putString("Potion", BuiltInRegistries.POTION.getKey(this.potion).toString());
		}

		if (this.fixedColor) {
			tag.putInt("Color", this.getColor());
		}

		if (!this.effects.isEmpty()) {
			ListTag listtag = new ListTag();

			for(MobEffectInstance mobeffectinstance : this.effects) {
				listtag.add(mobeffectinstance.save(new CompoundTag()));
			}

			tag.put("CustomPotionEffects", listtag);
		}
	}

	private void setFixedColor(int p_36883_) {
		this.fixedColor = true;
		this.entityData.set(ID_EFFECT_COLOR, p_36883_);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag $$0) {
		super.readAdditionalSaveData($$0);
		tier = ArcheryTiers.getByName($$0.getString("tier"));
		setTierData(tier);
		if ($$0.contains("Potion", 8)) {
			this.potion = PotionUtils.getPotion($$0);
		}

		for(MobEffectInstance mobeffectinstance : PotionUtils.getCustomEffects($$0)) {
			this.addEffect(mobeffectinstance);
		}

		if ($$0.contains("Color", 99)) {
			this.setFixedColor($$0.getInt("Color"));
		} else {
			this.updateColor();
		}
	}

	protected void doPostHurtEffects(LivingEntity p_36873_) {
		super.doPostHurtEffects(p_36873_);
		Entity entity = this.getEffectSource();

		for(MobEffectInstance mobeffectinstance : this.potion.getEffects()) {
			p_36873_.addEffect(new MobEffectInstance(mobeffectinstance.getEffect(), Math.max(mobeffectinstance.getDuration() / 8, 1), mobeffectinstance.getAmplifier(), mobeffectinstance.isAmbient(), mobeffectinstance.isVisible()), entity);
		}

		if (!this.effects.isEmpty()) {
			for(MobEffectInstance mobeffectinstance1 : this.effects) {
				p_36873_.addEffect(mobeffectinstance1, entity);
			}
		}

	}

	@Override
	public double getBaseDamage() {
		return tier.getDamage();
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(tierData, "stone");
		this.entityData.define(ID_EFFECT_COLOR, -1);
	}

	public void tick() {
		super.tick();
		if (this.level.isClientSide) {
			if (this.inGround) {
				if (this.inGroundTime % 5 == 0) {
					this.makeParticle(1);
				}
			} else {
				this.makeParticle(2);
			}
		} else if (this.inGround && this.inGroundTime != 0 && !this.effects.isEmpty() && this.inGroundTime >= 600) {
			this.level.broadcastEntityEvent(this, (byte)0);
			this.potion = Potions.EMPTY;
			this.effects.clear();
			this.entityData.set(ID_EFFECT_COLOR, -1);
		}

	}

	private void makeParticle(int p_36877_) {
		int i = this.getColor();
		if (i != -1 && p_36877_ > 0) {
			double d0 = (double)(i >> 16 & 255) / 255.0D;
			double d1 = (double)(i >> 8 & 255) / 255.0D;
			double d2 = (double)(i >> 0 & 255) / 255.0D;

			for(int j = 0; j < p_36877_; ++j) {
				this.level.addParticle(ParticleTypes.ENTITY_EFFECT, this.getRandomX(0.5D), this.getRandomY(), this.getRandomZ(0.5D), d0, d1, d2);
			}

		}
	}

	public int getColor() {
		return this.entityData.get(ID_EFFECT_COLOR);
	}

	@Override
	protected ItemStack getPickupItem() {

		ItemStack itemstack = new ItemStack(getArrowByTier(tier));
		if (this.effects.isEmpty() && this.potion == Potions.EMPTY) {
			return itemstack;
		} else {
			PotionUtils.setPotion(itemstack, this.potion);
			PotionUtils.setCustomEffects(itemstack, this.effects);
			if (this.fixedColor) {
				itemstack.getOrCreateTag().putInt("CustomPotionColor", this.getColor());
			}

			return itemstack;
		}
	}

	private ItemLike getArrowByTier(ArcheryTiers tier) {
		return switch (tier) {
			case STONE -> ItemInit.STONE_COLLECTION.getTippedArrow();
			case IRON -> ItemInit.IRON_COLLECTION.getTippedArrow();
			case GOLD -> ItemInit.GOLD_COLLECTION.getTippedArrow();
			case DIAMOND -> ItemInit.DIAMOND_COLLECTION.getTippedArrow();
			case NETHERITE -> ItemInit.NETHERITE_COLLECTION.getTippedArrow();
		};
	}

	private void setTierData(ArcheryTiers tier) {
		this.entityData.set(tierData, tier.getName());
	}

	public ArcheryTiers getTier() {
		return ArcheryTiers.getByName(entityData.get(tierData));
	}


	@Override
	public void onSyncedDataUpdated(EntityDataAccessor<?> $$0) {
		super.onSyncedDataUpdated($$0);
		if(tierData.equals($$0)) {
			this.tier = ArcheryTiers.getByName(this.entityData.get(tierData));
		}
	}

	public void handleEntityEvent(byte p_36869_) {
		if (p_36869_ == 0) {
			int i = this.getColor();
			if (i != -1) {
				double d0 = (double)(i >> 16 & 255) / 255.0D;
				double d1 = (double)(i >> 8 & 255) / 255.0D;
				double d2 = (double)(i >> 0 & 255) / 255.0D;

				for(int j = 0; j < 20; ++j) {
					this.level.addParticle(ParticleTypes.ENTITY_EFFECT, this.getRandomX(0.5D), this.getRandomY(), this.getRandomZ(0.5D), d0, d1, d2);
				}
			}
		} else {
			super.handleEntityEvent(p_36869_);
		}

	}
}