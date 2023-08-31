package com.nyfaria.nyfsarcheryplus.init;

import com.nyfaria.nyfsarcheryplus.Constants;
import com.nyfaria.nyfsarcheryplus.enums.ArcheryTiers;
import com.nyfaria.nyfsarcheryplus.item.AdvancedTippedArrowItem;
import com.nyfaria.nyfsarcheryplus.item.ArcheryCollection;
import com.nyfaria.nyfsarcheryplus.registration.RegistrationProvider;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;

public class ItemInit {

	public static final RegistrationProvider<Item> ITEMS = RegistrationProvider.get(Registries.ITEM, Constants.MODID);

	public static final ArcheryCollection<Item> NETHERITE_COLLECTION = ArcheryCollection.registerCollection(ArcheryTiers.NETHERITE);
	public static final ArcheryCollection<Item> DIAMOND_COLLECTION = ArcheryCollection.registerCollection(ArcheryTiers.DIAMOND);
	public static final ArcheryCollection<Item> GOLD_COLLECTION = ArcheryCollection.registerCollection(ArcheryTiers.GOLD);
	public static final ArcheryCollection<Item> IRON_COLLECTION = ArcheryCollection.registerCollection(ArcheryTiers.IRON);
	public static final ArcheryCollection<Item> STONE_COLLECTION = new ArcheryCollection<>(ArcheryTiers.STONE,null,null, ITEMS.register("stone_arrowhead", () -> new Item(new Item.Properties().stacksTo(64))),ITEMS.register("stone_tipped_arrow", () -> new AdvancedTippedArrowItem(new Item.Properties(),ArcheryTiers.STONE)));


	public static void loadClass() {
	}
}