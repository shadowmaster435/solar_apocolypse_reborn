package org.shadowmaster435.solar_apocalypse.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.shadowmaster435.solar_apocalypse.util.MiscUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FlowableFluid.class)
public class FluidMixin {

    @Inject(at = @At("TAIL"), method = "onScheduledTick")
    public void tick(World world, BlockPos pos, FluidState state, CallbackInfo ci) {
        if (MiscUtil.can_see_sky_safely(world, pos, 2)) {
            world.setBlockState(pos, Blocks.AIR.getDefaultState());
        }
    }
}

