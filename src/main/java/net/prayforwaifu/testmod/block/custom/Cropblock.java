package net.prayforwaifu.testmod.block.custom;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.prayforwaifu.testmod.item.ModItems;

public class Cropblock extends CropBlock {
    // This is to create the minimum age and the maximum age of the crop "0" and "6"
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 6);

    public Cropblock(Properties properties) {
        super(properties);
    }

    // this has the return the seed item
    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.CROP_SEED.get();
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    // the maximum age of the plant
    @Override
    public int getMaxAge() {
        return 6;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
