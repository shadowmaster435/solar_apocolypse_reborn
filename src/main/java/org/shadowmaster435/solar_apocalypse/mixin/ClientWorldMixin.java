package org.shadowmaster435.solar_apocalypse.mixin;

import net.minecraft.client.world.ClientWorld;
import org.shadowmaster435.solar_apocalypse.rendering.WaterBubble;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.BooleanSupplier;

@Mixin(ClientWorld.class)
public class ClientWorldMixin {
    @Inject(at = @At("TAIL"), method = "tick")
    public void tick(BooleanSupplier shouldKeepTicking, CallbackInfo ci) {
        WaterBubble.tickAll();
    }
}
