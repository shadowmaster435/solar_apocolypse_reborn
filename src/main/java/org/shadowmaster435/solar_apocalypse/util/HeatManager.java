package org.shadowmaster435.solar_apocalypse.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.StriderEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.vehicle.*;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.apache.logging.log4j.core.jmx.Server;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2i;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class HeatManager {
    private static final int display_heat_cap = 100;
    public static HashMap<Entity, ArrayList<Integer>> heat_map = new HashMap<>();

    public static HashMap<UUID, ArrayList<Integer>> player_heat_map = new HashMap<>();
    public static ArrayList<Entity> to_remove = new ArrayList<>();
    public static final Identifier thermometer_texture = new Identifier("solar_apocalypse","textures/ui/thermometer.png");
    public static void update_heat_map(int heat, int heat_delay, Entity entity) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(heat);
        list.add(heat_delay);
        heat_map.put(entity, list);
    }
    public static void update_heat_player_heat_map() {
        for (UUID uuid : player_heat_map.keySet()) {
            ArrayList<Integer> val = player_heat_map.get(uuid);
            for (Entity entity : heat_map.keySet()) {
                if (Objects.equals(entity.getUuidAsString(), uuid.toString())) {
                    IntegratedServer server = MinecraftClient.getInstance().getServer();
                    if (server != null) {
                        ServerWorld world = server.getWorld(World.NETHER);
                        if (world != null) {
                            heat_map.put(world.getEntity(uuid), val);
                        }
                    }
                }
            }
        }
    }
    public static HashMap<ServerPlayerEntity, ArrayList<Integer>> get_player_heat_map() {
        HashMap<Entity, ArrayList<Integer>> initial = heat_map;
        HashMap<ServerPlayerEntity, ArrayList<Integer>> result = new HashMap<>();
        initial.forEach((entity, integers) -> {
            ArrayList<Integer> vals = new ArrayList<>();
            if (entity instanceof ServerPlayerEntity) {
                vals.add(integers.get(0));
                vals.add(integers.get(1));
                result.put((ServerPlayerEntity) entity, vals);
            }
        });
        return result;
    }

    public static void tick_heat(@NotNull Entity entity) {
        int scalar = 120;


        if (!entity.isRemoved()) {
            ArrayList<Integer> arr = heat_map.get(entity);
            if (arr != null) {
                int heat = arr.get(0);
                int heat_add_delay = arr.get(1);

                if (heat_map.containsKey(entity)) {

                    if (heat_add_delay < scalar) {

                        arr.set(1, heat_add_delay + 1);
                    } else {

                        if (in_nether_and_overheatable(entity)) {
                            arr.set(1, 0);
                            arr.set(0, heat + 1);
                        } else {
                            arr.set(1, 0);
                            arr.set(0, 0);
                        }
                    }
                    if (heat >= display_heat_cap) {
                        entity.setFireTicks(100);
                        if (entity instanceof LivingEntity livingEntity) {
                            if (livingEntity.hasStatusEffect(StatusEffects.FIRE_RESISTANCE)) {
                                livingEntity.removeStatusEffect(StatusEffects.FIRE_RESISTANCE);
                            }
                        }
                    }
                }
            } else {
                if (!to_remove.contains(entity)) {
                    to_remove.add(entity);
                }
            }
        } else {
            heat_map.remove(entity);
        }

    }

    public static boolean in_nether_and_overheatable(Entity entity) {
        boolean non_overheating = !(
                entity instanceof StriderEntity
                || entity instanceof BlazeEntity
                || entity instanceof MagmaCubeEntity
                || entity instanceof PiglinEntity
                || entity instanceof PiglinBruteEntity
                || entity instanceof WitherSkeletonEntity
                || entity instanceof SkeletonEntity
                || entity instanceof HoglinEntity
                || entity instanceof ZombifiedPiglinEntity
                || entity instanceof EndermanEntity
                || entity instanceof GhastEntity
                || entity instanceof ItemEntity
                || entity instanceof ProjectileEntity
                || entity instanceof FallingBlockEntity
                || entity instanceof BoatEntity
                || entity instanceof AbstractMinecartEntity
        );
        boolean in_nether = entity.getEntityWorld().getRegistryKey() == World.NETHER;
        return in_nether && non_overheating;
    }

    public static void render_thermometer(DrawContext context, MinecraftClient client, float tickDelta) {
        Vector2i uv = get_thermometer_progress_uv(client.player);
        float ratio = (float) context.getScaledWindowWidth() / context.getScaledWindowHeight();
        Vector2i xy = new Vector2i((int) (32 / ratio), (int) (128 / ratio));
        assert client.player != null;
        if (client.player.getWorld().getRegistryKey() == World.NETHER) {
            context.drawTexture(thermometer_texture, xy.x, xy.y, 0, 0, 9, 100);

            context.drawTexture(thermometer_texture, xy.x, uv.y + xy.y, uv.x, uv.y, 9, 100);

        }
    }

    public static Vector2i get_thermometer_progress_uv(ClientPlayerEntity entity) {

        ArrayList<Integer> list = heat_map.get(entity);
        int u;
        int v = (list != null) ? heat_map.get(entity).get(0) : 0;
        if (v >= 33 && v < 66) {
            u = 18;
        } else if (v >= 66) {
            u = 27;
        } else {
            u = 9;
        }
        return new Vector2i(u, Math.max(0, 100 - v));
    }


}
