package com.nyfaria.nyfsarcheryplus.enums;

import net.minecraft.tags.ItemTags;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;

import java.util.function.Supplier;

public enum ArcheryTiers {
    STONE("stone",3, 853, 1032, () -> Ingredient.of(Tags.Items.STONE)),
    IRON("iron",4, 1627, 1970, () -> Ingredient.of(Items.IRON_INGOT)),
    GOLD("golden",5, 208,252, ()-> Ingredient.of(Items.GOLD_INGOT)),
    DIAMOND("diamond",6,10160,12303, ()->Ingredient.of(Items.DIAMOND)),
    NETHERITE("netherite",7,13219,16007, ()->Ingredient.of(Items.NETHERITE_INGOT));

    private final int damage;
    private final String name;
    private final int durability;
    private final int crossBowDurability;

    private final LazyLoadedValue<Ingredient> repairIngredient;



    ArcheryTiers(String name, int damage, int durability, int crossBowDurability, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.damage = damage;
        this.durability = durability;
        this.crossBowDurability = crossBowDurability;
        this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
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
}
