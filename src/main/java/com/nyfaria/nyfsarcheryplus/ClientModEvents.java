package com.nyfaria.nyfsarcheryplus;

import com.nyfaria.nyfsarcheryplus.render.entity.RenderDiamondTippedArrow;
import com.nyfaria.nyfsarcheryplus.render.entity.RenderGoldTippedArrow;
import com.nyfaria.nyfsarcheryplus.render.entity.RenderIronTippedArrow;
import com.nyfaria.nyfsarcheryplus.render.entity.RenderNetheriteTippedArrow;
import com.nyfaria.nyfsarcheryplus.render.entity.RenderStoneTippedArrow;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.renderer.item.ItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.item.Items;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NyfsArcheryPlus .MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientModEvents {
    @Override
    public void onRendererRegistry(EntityRenderersEvent.RegisterRenderers event) {

    	ItemPropertyFunction pulling = ItemProperties.getProperty(Items.BOW, new ResourceLocation("pulling"));
        ItemPropertyFunction pull = (stack, worldIn, entity) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getUseItem() != stack ? 0.0F : (stack.getUseDuration() - entity.getUseItemRemainingTicks()) / 20.0F;
            }
        };
        ItemProperties.register(ItemInit.IRON_BOW.get(), new ResourceLocation("pulling"), pulling);
        ItemProperties.register(ItemInit.IRON_BOW.get(), new ResourceLocation("pull"), pull);
        ItemProperties.register(ItemInit.DIAMOND_BOW.get(), new ResourceLocation("pulling"), pulling);
        ItemProperties.register(ItemInit.DIAMOND_BOW.get(), new ResourceLocation("pull"), pull);
        ItemProperties.register(ItemInit.GOLD_BOW.get(), new ResourceLocation("pulling"), pulling);
        ItemProperties.register(ItemInit.GOLD_BOW.get(), new ResourceLocation("pull"), pull);
        ItemProperties.register(ItemInit.NETHERITE_BOW.get(), new ResourceLocation("pulling"), pulling);
        ItemProperties.register(ItemInit.NETHERITE_BOW.get(), new ResourceLocation("pull"), pull);
        event.registerEntityRenderer(EntityInit.STONE_TIPPED_ARROW_ENTITY.get(), RenderStoneTippedArrow::new);
        event.registerEntityRenderer(EntityInit.GOLD_TIPPED_ARROW_ENTITY.get(), RenderGoldTippedArrow::new);
        event.registerEntityRenderer(EntityInit.IRON_TIPPED_ARROW_ENTITY.get(), RenderIronTippedArrow::new);
        event.registerEntityRenderer(EntityInit.DIAMOND_TIPPED_ARROW_ENTITY.get(), RenderDiamondTippedArrow::new);
        event.registerEntityRenderer(EntityInit.NETHERITE_TIPPED_ARROW_ENTITY.get(), RenderNetheriteTippedArrow::new);
    }

    @Override
    public Player getClientPlayer(){
    	
        return Minecraft.getInstance().player;
    }

}
