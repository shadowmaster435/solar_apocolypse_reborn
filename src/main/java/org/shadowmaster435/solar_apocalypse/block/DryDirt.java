package org.shadowmaster435.solar_apocalypse.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.shadowmaster435.solar_apocalypse.registry.ModBlocks;
import org.shadowmaster435.solar_apocalypse.util.MiscUtil;

public class DryDirt extends Block {
    public DryDirt(Settings settings) {
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
        world.scheduleBlockTick(pos, this,1);
    }
}
