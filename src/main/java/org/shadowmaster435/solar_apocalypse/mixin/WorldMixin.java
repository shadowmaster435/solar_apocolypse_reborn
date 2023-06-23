package org.shadowmaster435.solar_apocalypse.mixin;

import net.minecraft.registry.RegistryKey;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(World.class)
public abstract class WorldMixin {

    @Shadow public abstract long getTimeOfDay();
    @Shadow @Final public static RegistryKey<World> OVERWORLD;




}
