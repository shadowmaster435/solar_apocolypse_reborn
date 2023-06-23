package org.shadowmaster435.solar_apocalypse.block;

import net.minecraft.block.*;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
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
        for (Direction direction : Direction.values()) {
            BlockState prior = world.getBlockState(pos.offset(direction).add(0, 1,0));
            if (direction.getAxis().isHorizontal() && ModBlocks.get_wilted_from_unwilted(prior) != prior ) {
                modify(pos.offset(direction).add(0, 1,0), world, prior);
            }
        }
        if (world.getBlockState(pos.add(0,1,0)).isFullCube(world, pos.add(0,1,0)) && world.getBlockState(pos.add(0,1,0)).isSolidBlock(world, pos.add(0,1,0))  && MiscUtil.can_see_sky_safely(world, pos, 3) && world.isDay()) {
            world.setBlockState(pos, ModBlocks.DRY_SOIL.getDefaultState(),Block.NOTIFY_ALL);
        }
        super.randomTick(state, world, pos, random);
    }

    public void modify(BlockPos pos, World world, BlockState state) {
        if (world.getBlockState(pos.add(0,1,0)).getBlock() instanceof TallPlantBlock) {
            world.setBlockState(pos, ModBlocks.get_wilted_from_unwilted(state).with(TallPlantBlock.HALF, DoubleBlockHalf.LOWER), Block.NOTIFY_ALL, 0);
            world.setBlockState(pos.add(0,1,0), ModBlocks.get_wilted_from_unwilted(state).with(TallPlantBlock.HALF, DoubleBlockHalf.UPPER), Block.NOTIFY_ALL);

        } else {
            if (ModBlocks.get_wilted_from_unwilted(state).getBlock() instanceof WiltedFlowerBlock flowerBlock) {
                world.setBlockState(pos, flowerBlock.getDefaultState(), Block.NOTIFY_ALL);

            } else {
                world.setBlockState(pos, ModBlocks.get_wilted_from_unwilted(state), Block.NOTIFY_ALL);

            }

        }
    }
}
