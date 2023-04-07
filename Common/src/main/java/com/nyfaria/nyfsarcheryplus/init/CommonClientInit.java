package com.nyfaria.nyfsarcheryplus.init;

import com.nyfaria.nyfsarcheryplus.enums.ArcheryTiers;
import com.nyfaria.nyfsarcheryplus.platform.Services;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Items;

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

        ItemProperties.register(Services.PLATFORM.getArcherCollection(ArcheryTiers.IRON).getBow(), new ResourceLocation("pulling"), pulling);
        ItemProperties.register(Services.PLATFORM.getArcherCollection(ArcheryTiers.IRON).getBow(), new ResourceLocation("pull"), pull);
        ItemProperties.register(Services.PLATFORM.getArcherCollection(ArcheryTiers.DIAMOND).getBow(), new ResourceLocation("pulling"), pulling);
        ItemProperties.register(Services.PLATFORM.getArcherCollection(ArcheryTiers.DIAMOND).getBow(), new ResourceLocation("pull"), pull);
        ItemProperties.register(Services.PLATFORM.getArcherCollection(ArcheryTiers.GOLD).getBow(), new ResourceLocation("pulling"), pulling);
        ItemProperties.register(Services.PLATFORM.getArcherCollection(ArcheryTiers.GOLD).getBow(), new ResourceLocation("pull"), pull);
        ItemProperties.register(Services.PLATFORM.getArcherCollection(ArcheryTiers.NETHERITE).getBow(), new ResourceLocation("pulling"), pulling);
        ItemProperties.register(Services.PLATFORM.getArcherCollection(ArcheryTiers.NETHERITE).getBow(), new ResourceLocation("pull"), pull);
        ItemProperties.register(Services.PLATFORM.getArcherCollection(ArcheryTiers.IRON).getCrossbow(), new ResourceLocation("pulling"), cbPulling);
        ItemProperties.register(Services.PLATFORM.getArcherCollection(ArcheryTiers.IRON).getCrossbow(), new ResourceLocation("pull"), cbPull);
        ItemProperties.register(Services.PLATFORM.getArcherCollection(ArcheryTiers.IRON).getCrossbow(), new ResourceLocation("charged"), charged);
        ItemProperties.register(Services.PLATFORM.getArcherCollection(ArcheryTiers.IRON).getCrossbow(), new ResourceLocation("firework"), firework);
        ItemProperties.register(Services.PLATFORM.getArcherCollection(ArcheryTiers.DIAMOND).getCrossbow(), new ResourceLocation("pulling"), cbPulling);
        ItemProperties.register(Services.PLATFORM.getArcherCollection(ArcheryTiers.DIAMOND).getCrossbow(), new ResourceLocation("pull"), cbPull);
        ItemProperties.register(Services.PLATFORM.getArcherCollection(ArcheryTiers.DIAMOND).getCrossbow(), new ResourceLocation("charged"), charged);
        ItemProperties.register(Services.PLATFORM.getArcherCollection(ArcheryTiers.DIAMOND).getCrossbow(), new ResourceLocation("firework"), firework);
        ItemProperties.register(Services.PLATFORM.getArcherCollection(ArcheryTiers.GOLD).getCrossbow(), new ResourceLocation("pulling"), cbPulling);
        ItemProperties.register(Services.PLATFORM.getArcherCollection(ArcheryTiers.GOLD).getCrossbow(), new ResourceLocation("pull"), cbPull);
        ItemProperties.register(Services.PLATFORM.getArcherCollection(ArcheryTiers.GOLD).getCrossbow(), new ResourceLocation("charged"), charged);
        ItemProperties.register(Services.PLATFORM.getArcherCollection(ArcheryTiers.GOLD).getCrossbow(), new ResourceLocation("firework"), firework);
        ItemProperties.register(Services.PLATFORM.getArcherCollection(ArcheryTiers.NETHERITE).getCrossbow(), new ResourceLocation("pulling"), cbPulling);
        ItemProperties.register(Services.PLATFORM.getArcherCollection(ArcheryTiers.NETHERITE).getCrossbow(), new ResourceLocation("pull"), cbPull);
        ItemProperties.register(Services.PLATFORM.getArcherCollection(ArcheryTiers.NETHERITE).getCrossbow(), new ResourceLocation("charged"), charged);
        ItemProperties.register(Services.PLATFORM.getArcherCollection(ArcheryTiers.NETHERITE).getCrossbow(), new ResourceLocation("firework"), firework);
    }

}
