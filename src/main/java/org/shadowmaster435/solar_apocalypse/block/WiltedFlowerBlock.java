package org.shadowmaster435.solar_apocalypse.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class WiltedFlowerBlock extends PlantBlock {

    public WiltedFlowerBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockPos pos = ctx.getBlockPos();
        Random random = Random.create(pos.getX() + pos.getY() + pos.getZ());
        return this.getDefaultState().with(Properties.HORIZONTAL_FACING, intDir(random.nextBetween(0, 3)));
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Vec3d vec3d = state.getModelOffset(world, pos);
        return Block.createCuboidShape(4,0.0,4,12,8,12).offset(vec3d.x, vec3d.y, vec3d.z);
    }
    public static Direction intDir(int i) {
        switch (i) {
            case 1 ->  {
                return Direction.EAST;
            }
            case 2 ->  {
                return Direction.SOUTH;
            }
            case 3 ->  {
                return Direction.WEST;
            }
            default -> {
                return Direction.NORTH;
            }
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
    }

}
