package com.nyfaria.nyfsarcheryplus.items;

import com.nyfaria.nyfsarcheryplus.enums.ArcheryTiers;
import net.minecraft.world.item.*;

public class AdvancedCrossBowItem extends CrossbowItem {

	private final ArcheryTiers tier;

	public AdvancedCrossBowItem(Properties properties, ArcheryTiers tier) {
		super(properties.stacksTo(1).defaultDurability(tier.getDurability()).tab(CreativeModeTab.TAB_COMBAT));
		this.tier = tier;
	}
	@Override
	public boolean isValidRepairItem(ItemStack p_43311_, ItemStack p_43312_) {
		return this.tier.getRepairIngredient().test(p_43312_) || super.isValidRepairItem(p_43311_, p_43312_);
	}
}
