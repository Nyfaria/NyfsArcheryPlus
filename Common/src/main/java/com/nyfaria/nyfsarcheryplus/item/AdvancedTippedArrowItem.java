package com.nyfaria.nyfsarcheryplus.item;


import com.nyfaria.nyfsarcheryplus.entity.AdvancedTippedArrowEntity;
import com.nyfaria.nyfsarcheryplus.enums.ArcheryTiers;
import com.nyfaria.nyfsarcheryplus.platform.Services;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Position;
import net.minecraft.core.Registry;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.List;

public class AdvancedTippedArrowItem extends ArrowItem {

	private ArcheryTiers tier;

	public AdvancedTippedArrowItem(Properties properties, ArcheryTiers tier) {
		super(properties.stacksTo(64));
		this.tier = tier;
		DispenserBlock.registerBehavior(this, new AbstractProjectileDispenseBehavior()
		{
			@Override
			protected Projectile getProjectile(Level worldIn, Position position, ItemStack stackIn) {
				AdvancedTippedArrowEntity entityArrow = new AdvancedTippedArrowEntity(position.x(), position.y(), position.z(),worldIn , tier);
				entityArrow.pickup = AbstractArrow.Pickup.ALLOWED;
				return entityArrow;
			}
		});
		
	}
	public void appendHoverText(ItemStack $$0, @Nullable Level $$1, List<Component> $$2, TooltipFlag $$3) {
		PotionUtils.addPotionTooltip($$0, $$2, 0.125F);
	}
	@Override
	public AbstractArrow createArrow(Level world, ItemStack stack, LivingEntity player) {
		AdvancedTippedArrowEntity arrow = new AdvancedTippedArrowEntity(world,player,tier);
		arrow.setEffectsFromItem(stack);
		return arrow;
	}

	public void fillItemCategory(CreativeModeTab $$0, NonNullList<ItemStack> $$1) {
		if (this.allowdedIn($$0)) {
			Iterator var3 = Registry.POTION.iterator();

			while(var3.hasNext()) {
				Potion $$2 = (Potion)var3.next();
				if (!$$2.getEffects().isEmpty()) {
					$$1.add(PotionUtils.setPotion(new ItemStack(this), $$2));
				}
			}
		}
		super.fillItemCategory($$0, $$1);

	}
	public ArcheryTiers getTier() {
		return tier;
	}
	public void setTier(ArcheryTiers tier) {
		this.tier = tier;
	}
}