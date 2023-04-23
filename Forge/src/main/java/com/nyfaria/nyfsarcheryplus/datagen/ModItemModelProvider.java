package com.nyfaria.nyfsarcheryplus.datagen;

import com.nyfaria.nyfsarcheryplus.Constants;
import com.nyfaria.nyfsarcheryplus.init.ItemInit;
import com.nyfaria.nyfsarcheryplus.item.ArcheryCollection;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.stream.Stream;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput generator, ExistingFileHelper existingFileHelper) {
        super(generator, Constants.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        Stream.of(
                ItemInit.DIAMOND_COLLECTION,
                ItemInit.GOLD_COLLECTION,
                ItemInit.IRON_COLLECTION,
                ItemInit.NETHERITE_COLLECTION,
                ItemInit.STONE_COLLECTION
        ).map(ArcheryCollection::getTippedArrow)
                .forEach(this::tippedArrow);
    }

    protected ItemModelBuilder simpleBlockItemModel(Block block) {
        String name = getName(block);
        return withExistingParent(name, modLoc("block/" + name));
    }

    protected  ItemModelBuilder tippedArrow(Item item){
        return withExistingParent(getName(item), mcLoc("item/generated"))
                .texture("layer0", modLoc("item/"+getName(item)))
                .override()
                .predicate(new ResourceLocation("color"),1f)
                .model(
                        withExistingParent(getName(item)+"_potion", mcLoc("item/generated"))
                                .texture("layer0", mcLoc("item/tipped_arrow_head"))
                                .texture("layer1", modLoc("item/" + getName(item)))
                ).end();
    }


    protected ItemModelBuilder simpleGeneratedModel(Item item) {
        return simpleModel(item, mcLoc("item/generated"));
    }

    protected ItemModelBuilder simpleHandHeldModel(Item item) {
        return simpleModel(item, mcLoc("item/handheld"));
    }

    protected ItemModelBuilder simpleModel(Item item, ResourceLocation parent) {
        String name = getName(item);
        return singleTexture(name, parent, "layer0", modLoc("item/" + name));
    }

    protected String getName(Item item) {
        return ForgeRegistries.ITEMS.getKey(item).getPath();
    }

    protected String getName(Block item) {
        return ForgeRegistries.BLOCKS.getKey(item).getPath();
    }
}
