package com.nyfaria.nyfsarcheryplus.datagen;

import com.nyfaria.nyfsarcheryplus.Constants;
import com.nyfaria.nyfsarcheryplus.enums.ArcheryTiers;
import com.nyfaria.nyfsarcheryplus.init.ItemInit;
import com.nyfaria.nyfsarcheryplus.item.ArcheryCollection;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
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
        super(generator.getPackOutput());
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> recipeSaver) {
        archeryCollectionRecipe(Tags.Items.STONE, ItemInit.STONE_COLLECTION, recipeSaver);
        archeryCollectionRecipe(Items.IRON_INGOT, ItemInit.IRON_COLLECTION, recipeSaver);
        archeryCollectionRecipe(Items.GOLD_INGOT, ItemInit.GOLD_COLLECTION, recipeSaver);
        archeryCollectionRecipe(Items.DIAMOND, ItemInit.DIAMOND_COLLECTION, recipeSaver);
        archeryCollectionRecipe(Items.NETHERITE_INGOT, ItemInit.NETHERITE_COLLECTION, recipeSaver);
    }

    public static void archeryCollectionRecipe(TagKey<Item> item, ArcheryCollection<?> collection, Consumer<FinishedRecipe> recipeSaver) {
        if (collection.getBow() != null) {
            SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(collection.getTier().getUpgradeFrom().get()), Ingredient.of(item), RecipeCategory.MISC, collection.getBow())
                    .unlocks("has_item", has(item))
                    .save(recipeSaver, new ResourceLocation(Constants.MODID, collection.getTier().getName() + "_bow_upgrade"));
//            ShapedRecipeBuilder.shaped( collection.getBow())
//                    .define('S', Items.STRING)
//                    .define('I', item)
//                    .pattern(" IS")
//                    .pattern("I S")
//                    .pattern(" IS")
//                    .unlockedBy("has_item", has(item))
//                    .save(recipeSaver);
//            ShapedRecipeBuilder.shaped( collection.getBow())
//                    .define('S', Items.STRING)
//                    .define('I', item)
//                    .pattern("SI ")
//                    .pattern("S I")
//                    .pattern("SI ")
//                    .unlockedBy("has_item", has(item))
//                    .save(recipeSaver, new ResourceLocation(Constants.MODID, collection.getTier().getName() + "_bow_alt"));
        }
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, collection.getTippedArrow())
                .define('S', Items.STICK)
                .define('I', collection.getArrowTip())
                .define('F', Items.FEATHER)
                .pattern("I")
                .pattern("S")
                .pattern("F")
                .unlockedBy("has_item", has(collection.getArrowTip()))
                .save(recipeSaver);
        ArrowHeadRecipeBuilder.arrowHead(Ingredient.of(Items.FLINT), Ingredient.of(item), new ItemStack(collection.getArrowTip(), 9))
                .unlocks("has_item", has(item))
                .save(recipeSaver, new ResourceLocation(Constants.MODID, collection.getTier().getName() + "_arrowhead"));
        if (collection.getCrossbow() != null) {
            SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(Items.CROSSBOW), Ingredient.of(item), RecipeCategory.MISC, collection.getCrossbow())
                    .unlocks("has_item", has(item))
                    .save(recipeSaver, new ResourceLocation(Constants.MODID, collection.getTier().getName() + "_crossbow_upgrade"));
        }
    }

    public static void archeryCollectionRecipe(ItemLike item, ArcheryCollection<?> collection, Consumer<FinishedRecipe> recipeSaver) {
        if (collection.getTier() != ArcheryTiers.NETHERITE) {
            if (collection.getBow() != null) {
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(collection.getTier().getUpgradeFrom().get()), Ingredient.of(item),RecipeCategory.MISC, collection.getBow())
                        .unlocks("has_item", has(item))
                        .save(recipeSaver, new ResourceLocation(Constants.MODID, collection.getTier().getName() + "_bow_upgrade"));
            }
            if (collection.getCrossbow() != null) {
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(Items.CROSSBOW), Ingredient.of(item), RecipeCategory.MISC,collection.getCrossbow())
                        .unlocks("has_item", has(item))
                        .save(recipeSaver, new ResourceLocation(Constants.MODID, collection.getTier().getName() + "_crossbow_upgrade"));
            }
        } else {
            SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(ItemInit.DIAMOND_COLLECTION.getBow()), Ingredient.of(item),RecipeCategory.MISC, collection.getBow())
                    .unlocks("has_item", has(item))
                    .save(recipeSaver, new ResourceLocation(Constants.MODID, collection.getTier().getName() + "_bow_upgrade"));
            SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(ItemInit.DIAMOND_COLLECTION.getCrossbow()), Ingredient.of(item),RecipeCategory.MISC, collection.getCrossbow())
                    .unlocks("has_item", has(item))
                    .save(recipeSaver, new ResourceLocation(Constants.MODID, collection.getTier().getName() + "_crossbow_upgrade"));
        }
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,collection.getTippedArrow())
                .define('S', Items.STICK)
                .define('I', collection.getArrowTip())
                .define('F', Items.FEATHER)
                .pattern("I")
                .pattern("S")
                .pattern("F")
                .unlockedBy("has_item", has(collection.getArrowTip()))
                .save(recipeSaver);

        ArrowHeadRecipeBuilder.arrowHead(Ingredient.of(Items.FLINT), Ingredient.of(item), new ItemStack(collection.getArrowTip(), 9))
                .unlocks("has_item", has(item))
                .save(recipeSaver, new ResourceLocation(Constants.MODID, collection.getTier().getName() + "_arrowhead"));
    }

}
