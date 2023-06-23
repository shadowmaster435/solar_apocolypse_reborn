package org.shadowmaster435.solar_apocalypse.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class WiltedCropBlock extends PlantBlock {
    public final int[] age_shape_heights;
    public static IntProperty AGE = Properties.AGE_7;

    public WiltedCropBlock(Settings settings, int[] age_shape_heights) {
        super(settings);

        this.age_shape_heights = age_shape_heights;
        this.setDefaultState(this.stateManager.getDefaultState().with(AGE, 0));
    }



    public int[] getTestShapeHeights() {
        return new int[]{2,4,6,8,10,12,14,16};
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return fromAge(state);
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {


        stateManager.add(AGE);
    }
    public VoxelShape fromAge(BlockState state) {
        return Block.createCuboidShape(0,0,0,16, getTestShapeHeights()[this.getAge(state)], 16);
    }

    public int getAge(BlockState state) {
        return state.get(AGE);
    }

}
