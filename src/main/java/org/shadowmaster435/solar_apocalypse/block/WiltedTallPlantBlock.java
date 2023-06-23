package org.shadowmaster435.solar_apocalypse.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class WiltedTallPlantBlock extends TallPlantBlock {

    public WiltedTallPlantBlock(Settings settings) {
        super(settings);
    }


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Vec3d vec3d = state.getModelOffset(world, pos);

        return Block.createCuboidShape(2,0.0,2,14,16,14).offset(vec3d.x,vec3d.y,vec3d.z);
    }
}
