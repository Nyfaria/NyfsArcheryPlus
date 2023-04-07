package com.nyfaria.nyfsarcheryplus.client.renderer;

import com.nyfaria.nyfsarcheryplus.entity.AdvancedTippedArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class AdvancedTippedArrowRenderer<T extends AdvancedTippedArrowEntity> extends ArrowRenderer<T> {


    public AdvancedTippedArrowRenderer(EntityRendererProvider.Context render) {
        super(render);
    }


    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return new ResourceLocation("nyfsarcheryplus:textures/models/arrows/" + entity.getTier().getName() + "_tipped_arrow.png");
    }

}
