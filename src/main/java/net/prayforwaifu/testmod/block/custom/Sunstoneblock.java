package net.prayforwaifu.testmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class Sunstoneblock extends Block {

    public Sunstoneblock(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level level, BlockPos blockPos, BlockState blockState, Entity entity) {
        if (entity instanceof LivingEntity livingEntity){
            livingEntity.setSecondsOnFire(1);
        }

        super.stepOn(level, blockPos, blockState, entity);
    }
}
