package org.shadowmaster435.solar_apocalypse.mixin;


import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import org.shadowmaster435.solar_apocalypse.util.HeatManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin {


    @Shadow @Final private MinecraftClient client;

    @Inject(at = @At("TAIL"), method = "render")
    public void thermometer_renderer(DrawContext context, float tickDelta, CallbackInfo ci) {
        HeatManager.render_thermometer(context, client, tickDelta);
    }
}
