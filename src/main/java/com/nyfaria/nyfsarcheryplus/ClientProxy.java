package com.nyfaria.nyfsarcheryplus;

import com.nyfaria.nyfsarcheryplus.render.entity.RenderDiamondTippedArrow;
import com.nyfaria.nyfsarcheryplus.render.entity.RenderGoldTippedArrow;
import com.nyfaria.nyfsarcheryplus.render.entity.RenderIronTippedArrow;
import com.nyfaria.nyfsarcheryplus.render.entity.RenderNetheriteTippedArrow;
import com.nyfaria.nyfsarcheryplus.render.entity.RenderStoneTippedArrow;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{
    @Override
    public void init(){

    	IItemPropertyGetter pulling = ItemModelsProperties.getProperty(Items.BOW, new ResourceLocation("pulling"));
        IItemPropertyGetter pull = (stack, worldIn, entity) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getUseItem() != stack ? 0.0F : (stack.getUseDuration() - entity.getUseItemRemainingTicks()) / 20.0F;
            }
        };
        ItemModelsProperties.register(ItemInit.IRON_BOW.get(), new ResourceLocation("pulling"), pulling);
        ItemModelsProperties.register(ItemInit.IRON_BOW.get(), new ResourceLocation("pull"), pull);
        ItemModelsProperties.register(ItemInit.DIAMOND_BOW.get(), new ResourceLocation("pulling"), pulling);
        ItemModelsProperties.register(ItemInit.DIAMOND_BOW.get(), new ResourceLocation("pull"), pull);
        ItemModelsProperties.register(ItemInit.GOLD_BOW.get(), new ResourceLocation("pulling"), pulling);
        ItemModelsProperties.register(ItemInit.GOLD_BOW.get(), new ResourceLocation("pull"), pull);
        ItemModelsProperties.register(ItemInit.NETHERITE_BOW.get(), new ResourceLocation("pulling"), pulling);
        ItemModelsProperties.register(ItemInit.NETHERITE_BOW.get(), new ResourceLocation("pull"), pull);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.STA_ENTITYTYPE, manager -> new RenderStoneTippedArrow(manager));
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.GTA_ENTITYTYPE, manager -> new RenderGoldTippedArrow(manager));
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.ITA_ENTITYTYPE, manager -> new RenderIronTippedArrow(manager));
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.DTA_ENTITYTYPE, manager -> new RenderDiamondTippedArrow(manager));
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.NTA_ENTITYTYPE, manager -> new RenderNetheriteTippedArrow(manager));
    }

    @Override
    public PlayerEntity getClientPlayer(){
    	
        return Minecraft.getInstance().player;
    }

}
