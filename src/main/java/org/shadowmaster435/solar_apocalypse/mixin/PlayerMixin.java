package org.shadowmaster435.solar_apocalypse.mixin;


import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import org.shadowmaster435.solar_apocalypse.util.MiscUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerMixin {


    @Inject(at = @At("TAIL"), method = "tick")
    public void tick(CallbackInfo ci) {
        for (int i = 0; i < MiscUtil.iterate_count; ++i) {
            for (PlayerEntity player : ((PlayerEntity)(Object)this).getEntityWorld().getPlayers()) {

                MiscUtil.modify_world(((PlayerEntity) (Object) this).getEntityWorld(), player.getBlockPos());

            }

        }
    }
}
