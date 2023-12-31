package org.shadowmaster435.solar_apocalypse.mixin;

import net.minecraft.server.world.ServerWorld;
import org.shadowmaster435.solar_apocalypse.util.MiscUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.BooleanSupplier;

@Mixin(ServerWorld.class)
public class ServerWorldMixin {
    @Inject(at = @At("TAIL"), method = "tick")
    public void tick(BooleanSupplier shouldKeepTicking, CallbackInfo ci) {
        MiscUtil.tick();

    }
    @Inject(at = @At("HEAD"), method = "tickWeather", cancellable = true)
    public void tick(CallbackInfo ci) {
        if (MiscUtil.day >= 2) {
            ci.cancel();
        }

    }

}
