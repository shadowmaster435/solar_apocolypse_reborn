package org.shadowmaster435.solar_apocalypse.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockStateRaycastContext;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;
import org.shadowmaster435.solar_apocalypse.registry.ModBlocks;
import org.shadowmaster435.solar_apocalypse.util.HeatManager;
import org.shadowmaster435.solar_apocalypse.util.MiscUtil;
import org.shadowmaster435.solar_apocalypse.util.PersistantStates;
import org.shadowmaster435.solar_apocalypse.util.PlayerState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;
import java.util.UUID;

@Mixin(Entity.class)
public abstract class EntityMixin {
    @Shadow public abstract World getEntityWorld();

    @Shadow public abstract BlockPos getBlockPos();

    @Shadow public abstract void setFireTicks(int fireTicks);
    @Shadow public abstract Vec3d getPos();
    @Shadow public abstract void setInPowderSnow(boolean inPowderSnow);
    @Shadow public boolean inPowderSnow;

    @Shadow public abstract World getWorld();

    @Shadow private BlockPos blockPos;

    @Shadow public abstract UUID getUuid();

    @Shadow private Vec3d pos;

    @Inject(method = "readNbt", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;setVelocity(DDD)V", shift = At.Shift.AFTER))
    private void read_heat(NbtCompound nbt, CallbackInfo ci) {
        if (((Entity)(Object)this) instanceof ServerPlayerEntity player) {
            HeatManager.update_heat_player_heat_map();

        } else {
            HeatManager.update_heat_map(nbt.getInt("heat"), nbt.getInt("heat_delay"), ((Entity) (Object) this));
        }
    }
    @Inject(method = "writeNbt", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;getUuid()Ljava/util/UUID;", shift = At.Shift.AFTER))
    private void write_heat(NbtCompound nbt, CallbackInfoReturnable<NbtCompound> cir) {
        try {
            if (!(((Entity) (Object) this) instanceof PlayerEntity)) {
                if (HeatManager.heat_map.get(((Entity) (Object) this)) != null) {
                    nbt.putInt("heat", HeatManager.heat_map.get(((Entity) (Object) this)).get(0));
                    nbt.putInt("heat_delay", HeatManager.heat_map.get(((Entity) (Object) this)).get(1));
                }
            }
        } catch (Exception ignored) {

        }
    }
    @Inject(at = @At("TAIL"), method = "tick")
    public void tick(CallbackInfo ci) {
        HeatManager.tick_heat(((Entity) (Object) this));

    }

    @Inject(at = @At("TAIL"), method = "tick")
    public void cond_checker(CallbackInfo ci){
        World world = MinecraftClient.getInstance().world;
        BlockPos block_pos = getBlockPos();
        MiscUtil.burn_entity((((Entity) (Object) this)), block_pos);

    }
}
