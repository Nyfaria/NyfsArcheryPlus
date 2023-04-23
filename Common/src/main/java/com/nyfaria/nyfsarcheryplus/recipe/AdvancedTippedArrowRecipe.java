package com.nyfaria.nyfsarcheryplus.recipe;

import com.nyfaria.nyfsarcheryplus.init.RecipeInit;
import com.nyfaria.nyfsarcheryplus.item.AdvancedTippedArrowItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

public class AdvancedTippedArrowRecipe extends CustomRecipe {
    public AdvancedTippedArrowRecipe(ResourceLocation location) {
        super(location);
    }

    public boolean matches(CraftingContainer grid, Level level) {
        if (grid.getWidth() == 3 && grid.getHeight() == 3) {
            if (grid.getItem(0).getItem() instanceof AdvancedTippedArrowItem item) {
                for (int i = 0; i < grid.getWidth(); ++i) {
                    for (int j = 0; j < grid.getHeight(); ++j) {
                        ItemStack itemstack = grid.getItem(i + j * grid.getWidth());
                        if (itemstack.isEmpty()) {
                            return false;
                        }

                        if (i == 1 && j == 1) {
                            if (!itemstack.is(Items.LINGERING_POTION)) {
                                return false;
                            }
                        } else if (!(itemstack.is(item))) {
                            return false;
                        }
                    }
                }

                return true;
            }
        }
        return false;
    }



    public ItemStack assemble(CraftingContainer container) {
        ItemStack itemstack = container.getItem(1 + container.getWidth());
        if (!itemstack.is(Items.LINGERING_POTION)) {
            return ItemStack.EMPTY;
        } else {
            ItemStack itemstack1 = new ItemStack(container.getItem(0).getItem(), 8);
            PotionUtils.setPotion(itemstack1, PotionUtils.getPotion(itemstack));
            PotionUtils.setCustomEffects(itemstack1, PotionUtils.getCustomEffects(itemstack));
            return itemstack1;
        }
    }

    public boolean canCraftInDimensions(int x, int y) {
        return x >= 2 && y >= 2;
    }

    public RecipeSerializer<?> getSerializer() {
        return RecipeInit.ADVANCED_TIPPED_ARROW.get();
    }
}