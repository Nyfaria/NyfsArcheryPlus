package com.nyfaria.nyfsarcheryplus.init;

import com.nyfaria.nyfsarcheryplus.enums.ArcheryTiers;
import com.nyfaria.nyfsarcheryplus.platform.Services;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;

public class CommonClientInit {
    public static void clientSetup(){

        ClampedItemPropertyFunction cbPulling = (p_174615_, p_174616_, p_174617_, p_174618_) -> p_174617_ != null && p_174617_.isUsingItem() && p_174617_.getUseItem() == p_174615_ && !CrossbowItem.isCharged(p_174615_) ? 1.0F : 0.0F;
        ClampedItemPropertyFunction cbPull = (p_174620_, p_174621_, p_174622_, p_174623_) -> {
            if (p_174622_ == null) {
                return 0.0F;
            } else {
                return CrossbowItem.isCharged(p_174620_) ? 0.0F : (float)(p_174620_.getUseDuration() - p_174622_.getUseItemRemainingTicks()) / (float)CrossbowItem.getChargeDuration(p_174620_);
            }
        };
        ClampedItemPropertyFunction charged = (p_174610_, p_174611_, p_174612_, p_174613_) -> p_174612_ != null && CrossbowItem.isCharged(p_174610_) ? 1.0F : 0.0F;
        ClampedItemPropertyFunction firework = (p_174605_, p_174606_, p_174607_, p_174608_) -> p_174607_ != null && CrossbowItem.isCharged(p_174605_) && CrossbowItem.containsChargedProjectile(p_174605_, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
        ClampedItemPropertyFunction pulling = (p_174630_, p_174631_, p_174632_, p_174633_) -> p_174632_ != null && p_174632_.isUsingItem() && p_174632_.getUseItem() == p_174630_ ? 1.0F : 0.0F;
        ClampedItemPropertyFunction pull = (stack, worldIn, entity, a) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getUseItem() != stack ? 0.0F : (stack.getUseDuration() - entity.getUseItemRemainingTicks()) / 20.0F;
            }
        };
        ClampedItemPropertyFunction arrowColor = (p_174625_, p_174626_, p_174627_, p_174628_) -> {
            boolean flag = p_174625_.hasTag() && p_174625_.getTag().contains("Potion");
            return flag ? 1.0F : 0.0F;
        };
        ItemProperties.register(ItemInit.STONE_COLLECTION.getTippedArrow(), new ResourceLocation("color"), arrowColor);
        ItemProperties.register(ItemInit.IRON_COLLECTION.getBow(), new ResourceLocation("pulling"), pulling);
        ItemProperties.register(ItemInit.IRON_COLLECTION.getBow(), new ResourceLocation("pull"), pull);
        ItemProperties.register(ItemInit.IRON_COLLECTION.getCrossbow(), new ResourceLocation("pulling"), cbPulling);
        ItemProperties.register(ItemInit.IRON_COLLECTION.getCrossbow(), new ResourceLocation("pull"), cbPull);
        ItemProperties.register(ItemInit.IRON_COLLECTION.getCrossbow(), new ResourceLocation("charged"), charged);
        ItemProperties.register(ItemInit.IRON_COLLECTION.getCrossbow(), new ResourceLocation("firework"), firework);
        ItemProperties.register(ItemInit.IRON_COLLECTION.getTippedArrow(), new ResourceLocation("color"), arrowColor);
        ItemProperties.register(ItemInit.GOLD_COLLECTION.getBow(), new ResourceLocation("pulling"), pulling);
        ItemProperties.register(ItemInit.GOLD_COLLECTION.getBow(), new ResourceLocation("pull"), pull);
        ItemProperties.register(ItemInit.GOLD_COLLECTION.getCrossbow(), new ResourceLocation("pulling"), cbPulling);
        ItemProperties.register(ItemInit.GOLD_COLLECTION.getCrossbow(), new ResourceLocation("pull"), cbPull);
        ItemProperties.register(ItemInit.GOLD_COLLECTION.getCrossbow(), new ResourceLocation("charged"), charged);
        ItemProperties.register(ItemInit.GOLD_COLLECTION.getCrossbow(), new ResourceLocation("firework"), firework);
        ItemProperties.register(ItemInit.GOLD_COLLECTION.getTippedArrow(), new ResourceLocation("color"), arrowColor);
        ItemProperties.register(ItemInit.DIAMOND_COLLECTION.getBow(), new ResourceLocation("pulling"), pulling);
        ItemProperties.register(ItemInit.DIAMOND_COLLECTION.getBow(), new ResourceLocation("pull"), pull);
        ItemProperties.register(ItemInit.DIAMOND_COLLECTION.getCrossbow(), new ResourceLocation("pulling"), cbPulling);
        ItemProperties.register(ItemInit.DIAMOND_COLLECTION.getCrossbow(), new ResourceLocation("pull"), cbPull);
        ItemProperties.register(ItemInit.DIAMOND_COLLECTION.getCrossbow(), new ResourceLocation("charged"), charged);
        ItemProperties.register(ItemInit.DIAMOND_COLLECTION.getCrossbow(), new ResourceLocation("firework"), firework);
        ItemProperties.register(ItemInit.DIAMOND_COLLECTION.getTippedArrow(), new ResourceLocation("color"), arrowColor);
        ItemProperties.register(ItemInit.NETHERITE_COLLECTION.getBow(), new ResourceLocation("pulling"), pulling);
        ItemProperties.register(ItemInit.NETHERITE_COLLECTION.getBow(), new ResourceLocation("pull"), pull);
        ItemProperties.register(ItemInit.NETHERITE_COLLECTION.getCrossbow(), new ResourceLocation("pulling"), cbPulling);
        ItemProperties.register(ItemInit.NETHERITE_COLLECTION.getCrossbow(), new ResourceLocation("pull"), cbPull);
        ItemProperties.register(ItemInit.NETHERITE_COLLECTION.getCrossbow(), new ResourceLocation("charged"), charged);
        ItemProperties.register(ItemInit.NETHERITE_COLLECTION.getCrossbow(), new ResourceLocation("firework"), firework);
        ItemProperties.register(ItemInit.NETHERITE_COLLECTION.getTippedArrow(), new ResourceLocation("color"), arrowColor);

    }

}
