package com.nyfaria.nyfsarcheryplus.datagen;

import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;

public class ModBlockLootTables extends BlockLoot {
    @Override
    protected void addTables() {
//        this.getBlockStream().filter(this::shouldDropSelf).forEach(this::dropSelf);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return new ArrayList<>();
//        return this.getBlockStream().filter(this::shouldGenerateLoot).toList();
    }

//    protected Stream<Block> getBlockStream() {
//        return BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get);
//    }

    protected boolean shouldDropSelf(Block block) {
        return shouldGenerateLoot(block);
    }

    protected boolean shouldGenerateLoot(Block block) {
        return block.asItem() != Items.AIR;
    }

}
