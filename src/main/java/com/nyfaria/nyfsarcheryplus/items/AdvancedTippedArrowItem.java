package com.nyfaria.nyfsarcheryplus.items;


import com.nyfaria.nyfsarcheryplus.entities.AdvancedTippedArrowEntity;
import com.nyfaria.nyfsarcheryplus.enums.ArcheryTiers;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class AdvancedTippedArrowItem extends ArrowItem {

	private ArcheryTiers tier;

	public AdvancedTippedArrowItem(Properties properties, ArcheryTiers tier) {
		super(properties.tab(CreativeModeTab.TAB_COMBAT).stacksTo(64));
		this.tier = tier;
		
	}
	@Override
	public AbstractArrow createArrow(Level world, ItemStack stack, LivingEntity player) {
		return new AdvancedTippedArrowEntity(world,player,tier);
	}
	@Override
    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.world.entity.player.Player player) {
        int enchant = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, bow);
        return enchant > 0 && this.getClass() == AdvancedTippedArrowItem.class;
    }

	public ArcheryTiers getTier() {
		return tier;
	}
	public void setTier(ArcheryTiers tier) {
		this.tier = tier;
	}
}
