package com.nyfaria.nyfsarcheryplus.datagen;

import com.nyfaria.nyfsarcheryplus.NyfsArcheryPlus;
import com.nyfaria.nyfsarcheryplus.enums.ArcheryTiers;
import com.nyfaria.nyfsarcheryplus.init.ItemInit;
import com.nyfaria.nyfsarcheryplus.items.ArcheryCollection;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.UpgradeRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> recipeSaver) {
        archeryCollectionRecipe(Tags.Items.STONE, ItemInit.STONE_COLLECTION, recipeSaver);
        archeryCollectionRecipe(Items.IRON_INGOT, ItemInit.IRON_COLLECTION, recipeSaver);
        archeryCollectionRecipe(Items.GOLD_INGOT, ItemInit.GOLD_COLLECTION, recipeSaver);
        archeryCollectionRecipe(Items.DIAMOND, ItemInit.DIAMOND_COLLECTION, recipeSaver);
        archeryCollectionRecipe(Items.NETHERITE_INGOT, ItemInit.NETHERITE_COLLECTION, recipeSaver);
    }
    public static void archeryCollectionRecipe(TagKey<Item> item, ArcheryCollection<?> collection, Consumer<FinishedRecipe> recipeSaver){
        if(collection.getBow()!=null) {
            ShapedRecipeBuilder.shaped(collection.getBow())
                    .define('S', Items.STICK)
                    .define('I', item)
                    .pattern(" IS")
                    .pattern("I S")
                    .pattern(" IS")
                    .unlockedBy("has_item", has(item))
                    .save(recipeSaver);
        }
        ShapedRecipeBuilder.shaped(collection.getTippedArrow())
                .define('S', Items.STICK)
                .define('I', item)
                .define('F', Items.FEATHER)
                .pattern("I")
                .pattern("S")
                .pattern("F")
                .unlockedBy("has_item", has(item))
                .save(recipeSaver);
        ArrowHeadRecipeBuilder.arrowHead(Ingredient.of(Items.FLINT),Ingredient.of(item), new ItemStack(collection.getArrowTip(),9))
                .unlocks("has_item", has(item))
                .save(recipeSaver, new ResourceLocation(NyfsArcheryPlus.MODID,collection.getTier().getName() + "_arrowhead"));
        if(collection.getCrossbow()!=null) {
            UpgradeRecipeBuilder.smithing(Ingredient.of(Items.CROSSBOW), Ingredient.of(item), collection.getCrossbow())
                    .unlocks("has_item", has(item))
                    .save(recipeSaver, new ResourceLocation(NyfsArcheryPlus.MODID, collection.getTier().getName() + "_crossbow_upgrade"));
        }
    }
    public static void archeryCollectionRecipe(ItemLike item, ArcheryCollection<?> collection, Consumer<FinishedRecipe> recipeSaver){
        if(collection.getTier() != ArcheryTiers.NETHERITE) {
            if (collection.getBow() != null) {
                ShapedRecipeBuilder.shaped(collection.getBow())
                        .define('S', Items.STICK)
                        .define('I', item)
                        .pattern(" IS")
                        .pattern("I S")
                        .pattern(" IS")
                        .unlockedBy("has_item", has(item))
                        .save(recipeSaver);
            }
            if (collection.getCrossbow() != null) {
                UpgradeRecipeBuilder.smithing(Ingredient.of(Items.CROSSBOW), Ingredient.of(item), collection.getCrossbow())
                        .unlocks("has_item", has(item))
                        .save(recipeSaver, new ResourceLocation(NyfsArcheryPlus.MODID, collection.getTier().getName() + "_crossbow_upgrade"));
            }
        } else {
            UpgradeRecipeBuilder.smithing(Ingredient.of(ItemInit.DIAMOND_COLLECTION.getBow()),Ingredient.of(item), collection.getBow())
                    .unlocks("has_item", has(item))
                    .save(recipeSaver, new ResourceLocation(NyfsArcheryPlus.MODID, collection.getTier().getName() + "_bow_upgrade"));
            UpgradeRecipeBuilder.smithing(Ingredient.of(ItemInit.DIAMOND_COLLECTION.getCrossbow()),Ingredient.of(item), collection.getCrossbow())
                    .unlocks("has_item", has(item))
                    .save(recipeSaver, new ResourceLocation(NyfsArcheryPlus.MODID, collection.getTier().getName() + "_crossbow_upgrade"));
        }
        ShapedRecipeBuilder.shaped(collection.getTippedArrow())
                .define('S', Items.STICK)
                .define('I', item)
                .define('F', Items.FEATHER)
                .pattern("  I")
                .pattern(" S ")
                .pattern("F  ")
                .unlockedBy("has_item", has(item))
                .save(recipeSaver);

        ArrowHeadRecipeBuilder.arrowHead(Ingredient.of(Items.FLINT),Ingredient.of(item), new ItemStack(collection.getArrowTip(),9))
                .unlocks("has_item", has(item))
                .save(recipeSaver, new ResourceLocation(NyfsArcheryPlus.MODID,collection.getTier().getName() + "_arrowhead"));
    }
    private static InventoryChangeTrigger.TriggerInstance has(TagKey<Item> p_206407_) {
        return inventoryTrigger(ItemPredicate.Builder.item().of(p_206407_).build());
    }
}
