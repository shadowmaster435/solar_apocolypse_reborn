package org.shadowmaster435.solar_apocalypse.mixin;


import net.minecraft.client.network.ClientPlayerEntity;
import org.shadowmaster435.solar_apocalypse.rendering.WaterBubble;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public abstract class ClientPlayerMixin {


    @Inject(at = @At("TAIL"), method = "tick")
    public void tick(CallbackInfo ci) {
        ClientPlayerEntity self = (ClientPlayerEntity)(Object)this;
        WaterBubble.spawn_water_bubbles(self);
    }
}
