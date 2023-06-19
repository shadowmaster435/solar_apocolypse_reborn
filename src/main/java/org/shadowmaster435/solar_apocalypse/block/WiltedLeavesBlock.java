package org.shadowmaster435.solar_apocalypse.block;

import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.shadowmaster435.solar_apocalypse.registry.ModBlocks;
import org.shadowmaster435.solar_apocalypse.util.MiscUtil;

public class WiltedLeavesBlock extends Block {

    public WiltedLeavesBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getBlockState(pos.add(0,-1,0)).isOf(get_leaf_type(this.getDefaultState()).getBlock()) && MiscUtil.day >= 2) {
            world.setBlockState(pos.add(0,-1,0), this.getDefaultState(),Block.NOTIFY_ALL);
        }
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {

    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {

        if (random.nextInt() > 0.5) {

            if (MiscUtil.day >= 3) {
                world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);

            }
        }
        if (world.getBlockState(pos.add(0,-1,0)).getBlock() == get_leaf_type(state).getBlock() && MiscUtil.can_see_sky_safely(world, pos, 2) && world.isDay()) {
            world.setBlockState(pos.add(0,-1,0), this.getDefaultState(), Block.NOTIFY_ALL);
            world.scheduleBlockTick(pos, this, 1);

        }
        for (Direction direction : Direction.values()) {
            BlockState offset_state = world.getBlockState(pos.offset(direction, 1));
            if ( direction.getAxis().isHorizontal() && offset_state.getBlock() == get_leaf_type(this.getDefaultState()).getBlock() && get_leaf_type(this.getDefaultState()).getBlock() != Blocks.AIR) {
                world.setBlockState(pos.offset(direction, 1), this.getDefaultState(), Block.NOTIFY_ALL);
            }
        }
        super.randomTick(state, world, pos, random);
    }

    public static BlockState get_leaf_type(BlockState state) {
        Block block = state.getBlock();
        BlockState result = state;
        if (block.equals(ModBlocks.WILTED_OAK_LEAVES)) {
            result = Blocks.OAK_LEAVES.getDefaultState();
        } else if (block.equals(ModBlocks.WILTED_BIRCH_LEAVES)) {
            result = Blocks.BIRCH_LEAVES.getDefaultState();
        } else if (block.equals(ModBlocks.WILTED_SPRUCE_LEAVES)) {
            result = Blocks.SPRUCE_LEAVES.getDefaultState();
        } else if (block.equals(ModBlocks.WILTED_JUNGLE_LEAVES)) {
            result = Blocks.JUNGLE_LEAVES.getDefaultState();
        } else if (block.equals(ModBlocks.WILTED_ACACIA_LEAVES)) {
            result = Blocks.ACACIA_LEAVES.getDefaultState();
        } else if (block.equals(ModBlocks.WILTED_DARK_OAK_LEAVES)) {
            result = Blocks.DARK_OAK_LEAVES.getDefaultState();
        } else if (block.equals(ModBlocks.WILTED_MANGROVE_LEAVES)) {
            result = Blocks.MANGROVE_LEAVES.getDefaultState();
        } else if (block.equals(ModBlocks.WILTED_AZALEA_LEAVES)) {
            result = Blocks.AZALEA_LEAVES.getDefaultState();
        } else if (block.equals(ModBlocks.WILTED_FLOWERING_AZALEA_LEAVES)) {
            result = Blocks.FLOWERING_AZALEA_LEAVES.getDefaultState();
        } else if (block.equals(ModBlocks.WILTED_CHERRY_LEAVES)) {
            result = Blocks.CHERRY_LEAVES.getDefaultState();
        } else {
            result = Blocks.AIR.getDefaultState();
        }
        return result;
    }
}
