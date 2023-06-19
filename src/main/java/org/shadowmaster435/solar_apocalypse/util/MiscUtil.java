package org.shadowmaster435.solar_apocalypse.util;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.longs.Long2ObjectLinkedOpenHashMap;
import net.minecraft.block.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ChunkHolder;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.*;
import net.minecraft.world.chunk.WorldChunk;
import net.minecraft.world.tick.TickPriority;
import org.shadowmaster435.solar_apocalypse.config.SaveFile;
import org.shadowmaster435.solar_apocalypse.registry.ModBlocks;
import org.joml.Matrix4f;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class MiscUtil {
    public static boolean sun_drawn = false;
    public static int iterate_count = 8;

    public static int iterate_distance = 32;
    public static Long2ObjectLinkedOpenHashMap<ChunkHolder> currentChunkHolders;
    public static int moon_phase = 1;
    public static int phase_change_delay = 3;

    public static Identifier moon_texture = new Identifier("solar_apocalypse","textures/moon/moon1");
    public static int day = 0;
    public static int day_time = 1;

    public static int loaded_day_count = 0;
    public static boolean is_day = false;
    public static void update_day_count() {
        if (MinecraftClient.getInstance().getServer() != null) {
            PersistantStates states = PersistantStates.getPersistantStates(MinecraftClient.getInstance().getServer().getOverworld().getServer());

            World world = Objects.requireNonNull(MinecraftClient.getInstance().getServer()).getWorld(World.OVERWORLD);
            assert world != null;
            is_day = world.isDay();
            day_time = (int) (world.getTimeOfDay() + ((24000f) * day - 1));
            day = 1 + (int) Math.floor((world.getTimeOfDay() + 1) / 24000f);
            states.markDirty();
        }
    }
    private static final Identifier SUN = new Identifier("textures/environment/sun.png");

    public static void draw_sun(MatrixStack matrices) {
        BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
        Matrix4f matrix4f2 = matrices.peek().getPositionMatrix();

        float k = 30.0F + MathHelper.lerp(MathHelper.clamp(day_time - 54000f,1,72000f) / 72000f, 0, 370f);
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderTexture(0, SUN);
        bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
        bufferBuilder.vertex(matrix4f2, -k, 100.0F, -k).texture(0.0F, 0.0F).next();
        bufferBuilder.vertex(matrix4f2, k, 100.0F, -k).texture(1.0F, 0.0F).next();
        bufferBuilder.vertex(matrix4f2, k, 100.0F, k).texture(1.0F, 1.0F).next();
        bufferBuilder.vertex(matrix4f2, -k, 100.0F, k).texture(0.0F, 1.0F).next();
        BufferRenderer.drawWithGlobalProgram(bufferBuilder.end());
        draw_moon(matrices);
    }
    public static void draw_moon(MatrixStack matrices) {
        BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
        Matrix4f matrix4f2 = matrices.peek().getPositionMatrix();

        float k = 20.0f;
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderTexture(0, moon_texture);
        RenderSystem.disableCull();
        bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
        bufferBuilder.vertex(matrix4f2, -k, -100.0F, -k).texture(0.0F, 0.0F).next();
        bufferBuilder.vertex(matrix4f2, k, -100.0F, -k).texture(1.0F, 0.0F).next();
        bufferBuilder.vertex(matrix4f2, k, -100.0F, k).texture(1.0F, 1.0F).next();
        bufferBuilder.vertex(matrix4f2, -k, -100.0F, k).texture(0.0F, 1.0F).next();
        BufferRenderer.drawWithGlobalProgram(bufferBuilder.end());
        RenderSystem.enableCull();
    }
    public static void cycle_moon() {
        moon_texture = new Identifier("solar_apocalypse", "textures/moon/moon" + moon_phase + ".png");
        if (day >= 1) {
            if (phase_change_delay > 0) {
                phase_change_delay -= 1;
            } else {
                phase_change_delay = (int) MathHelper.clampedLerp(400f, 6f, (day_time - 48000f) / 48000f);
                if (moon_phase > 7) {
                    moon_phase = 1;
                } else {

                    moon_phase += 1;
                }
            }
        }
    }

    public static void debugthing(World world) {
        System.out.println();
    }

    public static Block[] full_remove_day_3 = {
            Blocks.WATER
    };
    public static Block[] random_remove_day_2 = {
            Blocks.SNOW
    };

    public static void tick() {
        cycle_moon();
        update_day_count();
        iterate_count = 256;
        iterate_distance = 256;
        SaveFile.save(SaveFile.get_world_name(), day, HeatManager.get_player_heat_map());
        SaveFile.read_save();

    }

    public static Block[] wilting = {
            Blocks.OAK_LEAVES, Blocks.SPRUCE_LEAVES, Blocks.BIRCH_LEAVES, Blocks.ACACIA_LEAVES, Blocks.DARK_OAK_LEAVES, Blocks.MANGROVE_LEAVES, Blocks.CHERRY_LEAVES, Blocks.JUNGLE_LEAVES, Blocks.AZALEA_LEAVES, Blocks.FLOWERING_AZALEA_LEAVES,
            Blocks.POPPY, Blocks.DANDELION, Blocks.AZURE_BLUET, Blocks.CORNFLOWER, Blocks.OXEYE_DAISY, Blocks.ORANGE_TULIP, Blocks.RED_TULIP, Blocks.WHITE_TULIP, Blocks.PINK_TULIP, Blocks.BLUE_ORCHID, Blocks.ROSE_BUSH, Blocks.PEONY, Blocks.LILAC,
            Blocks.ALLIUM, Blocks.LILY_OF_THE_VALLEY, Blocks.SUNFLOWER, Blocks.SUGAR_CANE, Blocks.WHEAT, Blocks.BEETROOTS, Blocks.CARROTS, Blocks.POTATOES, Blocks.GRASS, Blocks.TALL_GRASS, Blocks.GRASS_BLOCK, Blocks.MELON_STEM, Blocks.PUMPKIN_STEM, Blocks.ATTACHED_PUMPKIN_STEM, Blocks.ATTACHED_MELON_STEM,
            Blocks.FERN, Blocks.LARGE_FERN
    };

    public static Block[] random_melting = {
           Blocks.POWDER_SNOW, Blocks.ICE, Blocks.BLUE_ICE
    };
    public static boolean is_safe = false;


    public static void burn_entity(Entity entity, BlockPos block_pos) {


        if (MiscUtil.can_see_sky_safely(entity.getEntityWorld(), block_pos, 3)) {
            if (entity.getEntityWorld().isDay()) {
                if (entity instanceof PlayerEntity player) {
                    if (!player.isCreative() && !player.isSpectator()) {
                        entity.setFireTicks(100);
                    }
                } else {
                    entity.setFireTicks(100);
                }
            }
        }
    }
    public static boolean can_see_sky_safely(World world, BlockPos pos, int day_count) {
        boolean is_safe = false;


        return world.isSkyVisible(pos) && day >= day_count;
    }

    public static Block[] random_water_spawn_melting = {Blocks.SNOW_BLOCK, Blocks.PACKED_ICE};
    public static int remove_delay = 0;
    public static void modify_world(World world, BlockPos initial) {
        int rand_x = (int)(Math.random() * (iterate_distance * 2)) - iterate_distance;
        int rand_z = (int)(Math.random() * (iterate_distance * 2)) - iterate_distance;

        BlockPos randomized_pos = initial.add(rand_x, -1, rand_z);
        int y = world.getTopY(Heightmap.Type.WORLD_SURFACE, initial.getX() + rand_x,initial.getZ() + rand_z);
        BlockPos pos = new BlockPos(randomized_pos.getX(), y, randomized_pos.getZ());
        if (remove_delay <= 0) {
            IntegratedServer server = MinecraftClient.getInstance().getServer();
            if (server != null && server.getOverworld().isDay()) {
                if (can_see_sky_safely(world, pos, 2)) {
                    BlockState before = world.getBlockState(pos.subtract((new Vec3i(0, 1, 0))));
                    world.setBlockState(pos.subtract(new Vec3i(0, 1, 0)), MiscUtil.blockstate_changer(world, pos.subtract(new Vec3i(0, 1, 0))),Block.NOTIFY_ALL);
                    BlockState after = world.getBlockState(pos.subtract((new Vec3i(0, 1, 0))));
                    world.scheduleBlockRerenderIfNeeded(pos.subtract(new Vec3i(0, 1, 0)), before, after);
                    world.updateListeners(pos.subtract(new Vec3i(0, 1, 0)), before, after, 1);
                }
                remove_delay = 20;
            }
        } else {
            remove_delay -= 1;
        }
    }

    public static BlockState get_leaf_type(BlockState state) {
        Block block = state.getBlock();
        BlockState result = state;
        if (block.equals(Blocks.OAK_LEAVES)) {
            result = ModBlocks.WILTED_OAK_LEAVES.getDefaultState();
        } else if (block.equals(Blocks.BIRCH_LEAVES)) {
            result = ModBlocks.WILTED_BIRCH_LEAVES.getDefaultState();
        } else if (block.equals(Blocks.SPRUCE_LEAVES)) {
            result = ModBlocks.WILTED_SPRUCE_LEAVES.getDefaultState();
        } else if (block.equals(Blocks.JUNGLE_LEAVES)) {
            result = ModBlocks.WILTED_JUNGLE_LEAVES.getDefaultState();
        } else if (block.equals(Blocks.ACACIA_LEAVES)) {
            result = ModBlocks.WILTED_ACACIA_LEAVES.getDefaultState();
        } else if (block.equals(Blocks.DARK_OAK_LEAVES)) {
            result = ModBlocks.WILTED_DARK_OAK_LEAVES.getDefaultState();
        } else if (block.equals(Blocks.MANGROVE_LEAVES)) {
            result = ModBlocks.WILTED_MANGROVE_LEAVES.getDefaultState();
        } else if (block.equals(Blocks.AZALEA_LEAVES)) {
            result = ModBlocks.WILTED_AZALEA_LEAVES.getDefaultState();
        } else if (block.equals(Blocks.FLOWERING_AZALEA_LEAVES)) {
            result = ModBlocks.WILTED_FLOWERING_AZALEA_LEAVES.getDefaultState();
        } else if (block.equals(Blocks.CHERRY_LEAVES)) {
            result = ModBlocks.WILTED_CHERRY_LEAVES.getDefaultState();
        } else {
            result = Blocks.AIR.getDefaultState();
        }
        return result;
    }

    public static BlockState blockstate_changer(WorldAccess worldAccess, BlockPos pos) {

        Block block = worldAccess.getBlockState(pos).getBlock();
        if (Arrays.stream(wilting).toList().contains(block)) {
            if (block == Blocks.GRASS_BLOCK) {
                if (day >= 2) {
                    return ModBlocks.WILTED_GRASS_BLOCK.getDefaultState();
                } else {
                    return Blocks.GRASS_BLOCK.getDefaultState();
                }
            } else if (block == ModBlocks.WILTED_GRASS_BLOCK) {
                if (day >= 3) {
                    return ModBlocks.DRY_SOIL.getDefaultState();
                } else {
                    return ModBlocks.WILTED_GRASS_BLOCK.getDefaultState();
                }
            } else if (get_leaf_type(worldAccess.getBlockState(pos)) != Blocks.AIR.getDefaultState()) {
                    return get_leaf_type(worldAccess.getBlockState(pos));
            } else {

                return Blocks.AIR.getDefaultState();
            }
        } else {
            return worldAccess.getBlockState(pos);
        }
    }

}
