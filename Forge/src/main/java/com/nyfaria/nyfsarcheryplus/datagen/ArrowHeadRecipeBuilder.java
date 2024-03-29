package com.nyfaria.nyfsarcheryplus.datagen;

import com.google.gson.JsonObject;
import com.nyfaria.nyfsarcheryplus.init.RecipeInit;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class ArrowHeadRecipeBuilder {
    private final Ingredient template = Ingredient.EMPTY;
    private final Ingredient base;
    private final Ingredient addition;
    private final RecipeCategory category = RecipeCategory.COMBAT;
    private final ItemStack result;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();
    private final RecipeSerializer<?> type;

    public ArrowHeadRecipeBuilder(RecipeSerializer<?> p_126381_, Ingredient p_126382_, Ingredient p_126383_, ItemStack p_126384_) {
        this.type = p_126381_;
        this.base = p_126382_;
        this.addition = p_126383_;
        this.result = p_126384_;
    }

    public static ArrowHeadRecipeBuilder arrowHead(Ingredient p_126386_, Ingredient p_126387_,  ItemStack p_126388_) {
        return new ArrowHeadRecipeBuilder(RecipeSerializer.SMITHING_TRANSFORM, p_126386_, p_126387_, p_126388_);
    }

    public ArrowHeadRecipeBuilder unlocks(String p_126390_, CriterionTriggerInstance p_126391_) {
        this.advancement.addCriterion(p_126390_, p_126391_);
        return this;
    }

    public void save(Consumer<FinishedRecipe> p_126393_, String p_126394_) {
        this.save(p_126393_, new ResourceLocation(p_126394_));
    }

    public void save(Consumer<FinishedRecipe> p_126396_, ResourceLocation p_126397_) {
        this.ensureValid(p_126397_);
        this.advancement.parent(new ResourceLocation("recipes/root")).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(p_126397_)).rewards(AdvancementRewards.Builder.recipe(p_126397_)).requirements(RequirementsStrategy.OR);
        p_126396_.accept(new ArrowHeadRecipeBuilder.Result(p_126397_, this.type, this.template, this.base, this.addition, this.result, this.advancement, p_126397_.withPrefix("recipes/" + this.category.getFolderName() + "/")));
    }

    private void ensureValid(ResourceLocation p_126399_) {
        if (this.advancement.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + p_126399_);
        }
    }

    public static record Result(ResourceLocation id, RecipeSerializer<?> type, Ingredient template, Ingredient base, Ingredient addition, ItemStack result, Advancement.Builder advancement, ResourceLocation advancementId) implements FinishedRecipe {


        public void serializeRecipeData(JsonObject p_126416_) {
            p_126416_.add("template", this.template.toJson());
            p_126416_.add("base", this.base.toJson());
            p_126416_.add("addition", this.addition.toJson());
            JsonObject jsonobject = new JsonObject();
            jsonobject.addProperty("item", BuiltInRegistries.ITEM.getKey(this.result.getItem()).toString());
            if (this.result.getCount() > 1) {
                jsonobject.addProperty("count", this.result.getCount());
            }
            p_126416_.add("result", jsonobject);
        }

        public ResourceLocation getId() {
            return this.id;
        }

        public RecipeSerializer<?> getType() {
            return this.type;
        }

        @Nullable
        public JsonObject serializeAdvancement() {
            return this.advancement.serializeToJson();
        }

        @Nullable
        public ResourceLocation getAdvancementId() {
            return this.advancementId;
        }
    }
}
