package com.nyfaria.nyfsarcheryplus.enums;

import com.nyfaria.nyfsarcheryplus.init.ItemInit;
import com.nyfaria.nyfsarcheryplus.init.TagInit;
import com.nyfaria.nyfsarcheryplus.platform.Services;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ArcheryTiers {
    STONE("stone",3, 853, 1032, () -> Ingredient.of(TagInit.STONE), () -> Items.BOW),
    IRON("iron",4, 1627, 1970, () -> Ingredient.of(Items.IRON_INGOT),() -> Items.BOW),
    GOLD("golden",5, 208,252, ()-> Ingredient.of(Items.GOLD_INGOT),() -> Items.BOW),
    DIAMOND("diamond",6,10160,12303, ()->Ingredient.of(Items.DIAMOND),() -> Items.BOW),
    NETHERITE("netherite",7,13219,16007, ()->Ingredient.of(Items.NETHERITE_INGOT, Items.NETHERITE_SCRAP), ()->ItemInit.DIAMOND_COLLECTION.getBow());

    private final int damage;
    private final String name;
    private final int durability;
    private final int crossBowDurability;

    private final LazyLoadedValue<Ingredient> repairIngredient;
    private final Supplier<Item> upgradeFrom;



    ArcheryTiers(String name, int damage, int durability, int crossBowDurability, Supplier<Ingredient> repairIngredient, Supplier<Item> upgradeFrom) {
        this.name = name;
        this.damage = damage;
        this.durability = durability;
        this.crossBowDurability = crossBowDurability;
        this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
        this.upgradeFrom = upgradeFrom;
    }

    public String getName() {
        return name;
    }

    public int getCrossBowDurability() {
        return crossBowDurability;
    }

    public int getDamage() {
        return damage;
    }
    public int getDurability() {
        return durability;
    }
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public Supplier<Item> getUpgradeFrom() {
        return upgradeFrom;
    }
    public static ArcheryTiers getByName(String name){
        for(ArcheryTiers tier : ArcheryTiers.values()){
            if(tier.getName().equals(name)){
                return tier;
            }
        }
        return null;
    }
}