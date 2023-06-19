package org.shadowmaster435.solar_apocalypse.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.GrassBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.shadowmaster435.solar_apocalypse.registry.ModBlocks;
import org.shadowmaster435.solar_apocalypse.util.MiscUtil;

public class WiltedGrassBlock extends GrassBlock {
    public WiltedGrassBlock(Settings settings) {
        super(settings);
    }


    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getBlockState(pos.add(0,-1,0)).isOf(Blocks.DIRT) && MiscUtil.day >= 2) {
            world.setBlockState(pos.add(0,-1,0), ModBlocks.DRY_SOIL.getDefaultState(),Block.NOTIFY_ALL);
        }
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        world.scheduleBlockTick(pos, this, 1);
        if (world.getBlockState(pos.add(0,1,0)).getBlock() == Blocks.GRASS) {
            world.setBlockState(pos.add(0,1,0), ModBlocks.WILTED_GRASS.getDefaultState(),Block.NOTIFY_ALL);
        }
        if (world.getBlockState(pos.add(0,1,0)).getBlock() == Blocks.FERN) {
            world.setBlockState(pos.add(0,1,0), ModBlocks.WILTED_FERN.getDefaultState(),Block.NOTIFY_ALL);
        }
        if (world.getBlockState(pos.add(0,1,0)).getBlock() == Blocks.TALL_GRASS) {
            world.setBlockState(pos.add(0,1,0), ModBlocks.WILTED_TALL_GRASS.getDefaultState().with(Properties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER), Block.NOTIFY_ALL, 0);
            world.setBlockState(pos.add(0,2,0), ModBlocks.WILTED_TALL_GRASS.getDefaultState().with(Properties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), Block.NOTIFY_ALL);
        }
        for (Direction direction : Direction.values()) {
            if (direction.getAxis().isHorizontal() && world.getBlockState(pos.offset(direction, 1)).getBlock() == Blocks.GRASS_BLOCK) {
                world.setBlockState(pos.offset(direction, 1), this.getDefaultState(), Block.NOTIFY_ALL);
            }
        }
        if (world.getBlockState(pos.add(0,1,0)).isFullCube(world, pos.add(0,1,0)) && world.getBlockState(pos.add(0,1,0)).isSolidBlock(world, pos.add(0,1,0))  && MiscUtil.can_see_sky_safely(world, pos, 3) && world.isDay()) {
            world.setBlockState(pos, ModBlocks.DRY_SOIL.getDefaultState(),Block.NOTIFY_ALL);
        }
        super.randomTick(state, world, pos, random);
    }


}
