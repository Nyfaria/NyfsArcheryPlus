package com.nyfaria.nyfsarcheryplus.item;


import com.nyfaria.nyfsarcheryplus.entity.AdvancedTippedArrowEntity;
import com.nyfaria.nyfsarcheryplus.enums.ArcheryTiers;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class AdvancedTippedArrowItem extends ArrowItem {

	private ArcheryTiers tier;

	public AdvancedTippedArrowItem(Properties properties, ArcheryTiers tier) {
		super(properties.stacksTo(64));
		this.tier = tier;
		
	}
	@Override
	public AbstractArrow createArrow(Level world, ItemStack stack, LivingEntity player) {
		return new AdvancedTippedArrowEntity(world,player,tier);
//		return arrow;
	}


	public ArcheryTiers getTier() {
		return tier;
	}
	public void setTier(ArcheryTiers tier) {
		this.tier = tier;
	}
}