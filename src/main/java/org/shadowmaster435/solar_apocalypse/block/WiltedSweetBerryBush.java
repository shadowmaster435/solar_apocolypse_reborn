package org.shadowmaster435.solar_apocalypse.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class WiltedSweetBerryBush extends PlantBlock {
    public static IntProperty STAGE = IntProperty.of("age", 0, 1);

    public WiltedSweetBerryBush(Settings settings) {
        super(settings);


        this.setDefaultState(this.stateManager.getDefaultState().with(STAGE, 0));
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return fromAge(state);
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(STAGE);
    }
    public VoxelShape fromAge(BlockState state) {
        if (getAge(state) < 1) {
            return Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 8.0, 13.0);
        } else {
            return Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 16.0, 15.0);
        }
    }

    public int getAge(BlockState state) {
        return state.get(STAGE);
    }

}
