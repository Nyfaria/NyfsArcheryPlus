package com.nyfaria.nyfsarcheryplus.datagen;

import com.google.gson.JsonObject;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.UpgradeRecipeBuilder;
import net.minecraft.data.registries.RegistriesDatapackGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class ArrowHeadRecipeBuilder {
    private final Ingredient base;
    private final Ingredient addition;
    private final RecipeCategory category;
    private final ItemStack result;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();
    private final RecipeSerializer<?> type;

    public ArrowHeadRecipeBuilder(RecipeSerializer<?> p_126381_, Ingredient p_126382_, Ingredient p_126383_, RecipeCategory p_248993_, ItemStack p_126384_) {
        this.category = p_248993_;
        this.type = p_126381_;
        this.base = p_126382_;
        this.addition = p_126383_;
        this.result = p_126384_;
    }

    public static ArrowHeadRecipeBuilder arrowHead(Ingredient p_126386_, Ingredient p_126387_, RecipeCategory p_248633_, ItemStack p_126388_) {
        return new ArrowHeadRecipeBuilder(RecipeSerializer.SMITHING, p_126386_, p_126387_,p_248633_, p_126388_);
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
        this.advancement.parent(RecipeBuilder.ROOT_RECIPE_ADVANCEMENT).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(p_126397_)).rewards(AdvancementRewards.Builder.recipe(p_126397_)).requirements(RequirementsStrategy.OR);
        p_126396_.accept(new ArrowHeadRecipeBuilder.Result(p_126397_, this.type, this.base, this.addition, this.result, this.advancement, p_126397_.withPrefix("recipes/" + this.category.getFolderName() + "/")));
    }

    private void ensureValid(ResourceLocation p_126399_) {
        if (this.advancement.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + p_126399_);
        }
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final Ingredient base;
        private final Ingredient addition;
        private final ItemStack result;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;
        private final RecipeSerializer<?> type;

        public Result(ResourceLocation p_126408_, RecipeSerializer<?> p_126409_, Ingredient p_126410_, Ingredient p_126411_, ItemStack p_126412_, Advancement.Builder p_126413_, ResourceLocation p_126414_) {
            this.id = p_126408_;
            this.type = p_126409_;
            this.base = p_126410_;
            this.addition = p_126411_;
            this.result = p_126412_;
            this.advancement = p_126413_;
            this.advancementId = p_126414_;
        }

        public void serializeRecipeData(JsonObject p_126416_) {
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
