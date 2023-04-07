package com.nyfaria.nyfsarcheryplus.init;

import com.nyfaria.nyfsarcheryplus.entity.AdvancedTippedArrowEntity;
import com.nyfaria.nyfsarcheryplus.enums.ArcheryTiers;
import com.nyfaria.nyfsarcheryplus.platform.Services;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;

public class CommonInit {
    public static void preInit() {


        for(ArcheryTiers tier :ArcheryTiers.values()) {
            DispenserBlock.registerBehavior(Services.PLATFORM.getCommonTippedArrow(tier), new AbstractProjectileDispenseBehavior()
            {
                @Override
                protected Projectile getProjectile(Level worldIn, Position position, ItemStack stackIn) {
                    AdvancedTippedArrowEntity entityArrow = new AdvancedTippedArrowEntity(position.x(), position.y(), position.z(),worldIn , tier);
                    entityArrow.pickup = AbstractArrow.Pickup.ALLOWED;
                    return entityArrow;
                }
            });
        }
    }
}
