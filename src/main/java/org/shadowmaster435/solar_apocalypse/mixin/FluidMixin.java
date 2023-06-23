package org.shadowmaster435.solar_apocalypse.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FlowableFluid.class)
public class FluidMixin {
    @Inject(method = "canFlow", at = @At("RETURN"), cancellable = true)
    private void injected(BlockView world, BlockPos fluidPos, BlockState fluidBlockState, Direction flowDirection, BlockPos flowTo, BlockState flowToBlockState, FluidState fluidState, Fluid fluid, CallbackInfoReturnable<Boolean> cir) {
 /*       if (!MiscUtil.removal_finished) {
            cir.setReturnValue(false);
        }*/
    }
    @Inject(at = @At("TAIL"), method = "onScheduledTick")
    public void tick(World world, BlockPos pos, FluidState state, CallbackInfo ci) {
        //MiscUtil.evaporate(world, pos);
    }
}

