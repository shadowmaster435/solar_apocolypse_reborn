package org.shadowmaster435.solar_apocalypse.rendering;

import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.Camera;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.shadowmaster435.solar_apocalypse.util.MiscUtil;
import org.shadowmaster435.solar_apocalypse.util.RenderUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WaterBubble {

    public static List<WaterBubble> waterBubbles = new ArrayList<>();
    public static List<WaterBubble> toRemove = new ArrayList<>();
    private int lifetime = 10;
    private int current_frame = 0;
    private final String texture_path = "solar_apocalypse:textures/environment/water_bubble/water_bubble_";
    private Identifier final_texture_path = new Identifier("solar_apocalypse:textures/environment/water_bubble/water_bubble_0.png");
    private final Vector3f pos;
    public WaterBubble(Vector3f pos) {
        this.pos = pos;
    }
    public static void create_bubble(Vector3f pos) {
        waterBubbles.add(new WaterBubble(pos));
    }


    public static void spawn_water_bubbles(ClientPlayerEntity self) {
        MinecraftServer server = MinecraftClient.getInstance().getServer();
        if (server != null) {
            for (int iterate_count = 0; iterate_count < 64; ++iterate_count) {

                ClientWorld world = self.clientWorld;
                double rand_x = MathHelper.lerp(world.random.nextDouble(), -64.0, 64.0) + self.getX();
                double rand_z = MathHelper.lerp(world.random.nextDouble(), -64.0, 64.0) + self.getZ();
                double y = world.getTopY(Heightmap.Type.WORLD_SURFACE, (int) rand_x, (int) rand_z);
                BlockPos blockPos = BlockPos.ofFloored(rand_x, y, rand_z);
                Vector3f rand_pos = new Vector3f((float) rand_x, (float) y, (float) rand_z);
                boolean should_boil = MiscUtil.can_see_sky_safely_excluding_water_client(server.getOverworld(), blockPos, 3);
                if (should_boil && is_water_and_static(server.getOverworld(), blockPos.add(0, -1, 0))) {
                    WaterBubble.create_bubble(rand_pos);
                }
            }
        }
    }

    public static boolean is_water_and_static(World world, BlockPos pos) {
        boolean result = false;
        if (world.getBlockState(pos).isOf(Blocks.WATER)) {
            if (world.getFluidState(pos).isStill()) {
                result = true;
            }
        }
        return result;
    }
    public void tick() {
        if (lifetime > 0) {
            update_frame();
            lifetime -= 1;
        } else {
            remove();
        }
    }
    public static void tickAll() {
        for (Iterator<WaterBubble> iterator = waterBubbles.iterator(); iterator.hasNext();) {
            WaterBubble bubble = iterator.next();
            if (toRemove.contains(bubble)) {
                toRemove.remove(bubble);

                iterator.remove();
            } else {
                bubble.tick();
            }
        }
    }

    public static void renderAll(Vector3f ofs, MatrixStack stack, Matrix4f mat4) {
        for (Iterator<WaterBubble> iterator = waterBubbles.iterator(); iterator.hasNext();) {
            WaterBubble bubble = iterator.next();
            bubble.render(ofs, stack, mat4);
        }
    }
    public void remove() {
        toRemove.add(this);
    }
    public void update_frame() {
        if ((lifetime ) % 2 == 0) {
            current_frame += 1;
        }
        final_texture_path = new Identifier(texture_path + current_frame + ".png");
    }

    public void render(Vector3f ofs, MatrixStack stack, Matrix4f mat4) {
        Entity camera = MinecraftClient.getInstance().cameraEntity;
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        Camera cam = MinecraftClient.getInstance().gameRenderer.getCamera();

        float delta = MinecraftClient.getInstance().getTickDelta();
        if (player != null && camera != null) {
            RenderUtil.textured_colored_quad_no_cull(final_texture_path, stack.peek().getPositionMatrix(), cam.getPos().toVector3f().mul(-1).add(pos).add(0,-0.1f,0), 8, 8, 1.0f, 1.0f, 1.0f, 0.125f);
        }
    }

}
