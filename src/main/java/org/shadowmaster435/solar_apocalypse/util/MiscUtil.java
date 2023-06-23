package org.shadowmaster435.solar_apocalypse.util;

import com.mojang.blaze3d.systems.RenderSystem;
import it.unimi.dsi.fastutil.longs.Long2ObjectLinkedOpenHashMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.server.world.ChunkHolder;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.joml.Matrix4f;
import org.shadowmaster435.solar_apocalypse.config.SaveFile;
import org.shadowmaster435.solar_apocalypse.registry.ModBlocks;

import java.util.ArrayList;
import java.util.List;
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
        if (MiscUtil.can_see_sky_safely(entity.getEntityWorld(), block_pos, 3) && !(entity instanceof ItemEntity)) {
            if (entity.getEntityWorld().isDay() && entity.getEntityWorld().getRegistryKey() == World.OVERWORLD) {

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

    public static void boil_entity(Entity entity, BlockPos pos) {
        boolean is_player_and_survival = entity instanceof PlayerEntity player && player.isSpectator() && player.isCreative();

        boolean a = should_take_boil_damage(entity.getEntityWorld(), pos) && !is_player_and_survival;
        if (a) {
            entity.damage(entity.getDamageSources().generic(), 1);
        }
    }
    public static boolean can_see_sky_safely(World world, BlockPos pos, int day_count) {
        return world.isSkyVisible(pos) && !world.isClient && day >= day_count;
    }
    public static boolean can_see_sky_safely_excluding_water(World world, BlockPos pos, int day_count) {
        return world.isSkyVisibleAllowingSea(pos) && !world.isClient && day >= day_count && world.isDay();
    }
    public static boolean can_see_sky_safely_excluding_water_client(World world, BlockPos pos, int day_count) {

        return world.isSkyVisibleAllowingSea(pos) && day >= day_count && world.isDay();
    }
    public static boolean can_see_sky_safely_blockview(BlockRenderView world, BlockPos pos, int day_count) {
/*        if (MinecraftClient.getInstance().getServer() != null) {
            if (MinecraftClient.getInstance().getServer().getOverworld().isDay()) {
                return world.isSkyVisible(pos) && day >= day_count;

            } else {
                return false;
            }
        } else {
            return false;
        }*/
        return true;
    }
    public static boolean should_take_boil_damage(World world, BlockPos pos) {
        return (world.getBlockState(pos).isOf(Blocks.WATER) || world.getFluidState(pos).isOf(Fluids.FLOWING_WATER) || world.getFluidState(pos).isOf(Fluids.WATER)) && can_see_sky_safely_excluding_water(world, pos.add(0,1,0), 3);
    }

    public static int iterate_tracking = 0;
    public static List<BlockPos> queued = new ArrayList<>();
    public static List<BlockPos> queued_waterlogged = new ArrayList<>();

    public static void evaporate(World world, BlockPos default_pos) {

        boolean result = false;
        boolean air_above = world.isAir(default_pos.offset(Direction.UP));
        if (can_see_sky_safely(world, default_pos, 2) && air_above) {
            for (int i = 0; i < 128; ++i) {
                iterate_tracking += 1;

                BlockPos pos = default_pos.offset(Direction.DOWN, i);
                boolean kelp = world.getBlockState(pos).isOf(Blocks.KELP_PLANT) || world.getBlockState(pos).isOf(Blocks.KELP);
                boolean seagrass = world.getBlockState(pos).isOf(Blocks.SEAGRASS) || world.getBlockState(pos).isOf(Blocks.TALL_SEAGRASS);
                boolean sea_pickles = world.getBlockState(pos).isOf(Blocks.SEA_PICKLE);
                boolean water = world.getBlockState(pos).isOf(Blocks.WATER) && !world.getFluidState(pos).isOf(Fluids.FLOWING_WATER);

                boolean waterlogged = !sea_pickles && !seagrass && !kelp && world.getBlockState(pos).contains(Properties.WATERLOGGED);
                evaporate_under_overhangs(world, pos);

                if (kelp || seagrass || sea_pickles || water && !queued.contains(pos)) {
                    queued.add(pos);
                  //  world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);
                }
                if (waterlogged) {
                    if (!queued_waterlogged.contains(pos)) {
                        if (world.getBlockState(pos).get(Properties.WATERLOGGED)) {
                           // queued_waterlogged.add(pos);
                            //world.setBlockState(pos, world.getBlockState(pos).with(Properties.WATERLOGGED, false), Block.NOTIFY_ALL, 0);
                        }
                    }
                }
            }
        }
        remove_queued(world);
    }

    public static void evaporate_under_overhangs(World world, BlockPos original_pos) {
        for (Direction dir : Direction.values()) {

            if (should_evaporate(world, original_pos.offset(dir))) {
                if (!queued.contains(original_pos)) {
                    queued.add(original_pos);
                }
                iterate_tracking += 1;
                for (int i = 1; i < 8; ++i) {
                    BlockPos offset_1 = original_pos.offset(dir);
                    if (should_evaporate(world, offset_1)) {
                        iterate_tracking += 1;
                        if (!queued.contains(offset_1)) {
                            queued.add(offset_1);
                        }
                        for (int d = 1; d < 128; ++d) {

                            BlockPos offset_2 = offset_1.offset(Direction.DOWN, d);


                            if (world.getBlockState(offset_2).isOf(Blocks.WATER) ) {
                                iterate_tracking += 1;
                                if (!queued.contains(offset_2)) {
                                    queued.add(offset_2);
                                }

                            } else {
                                break;
                            }
                        }
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }
        }

    }
    public static boolean removal_finished = true;
    public static void remove_queued(World world) {
        iterate_tracking = 0;
        removal_finished = true;
        for (BlockPos pos : queued) {
            if (pos == queued.get(queued.size() - 1)) {
                removal_finished = false;
                if (queued.size() > 512) { // Max Queued Column Blocks
                    queued.clear();
                    removal_finished = true;

                }
                break;
            }
            iterate_tracking += 1;
            world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL, 1);
        }
        // leaves some positions behind but is a good compromise
        if (queued.size() > 0 && queued.size() < 16 && !removal_finished) {
            removal_finished = true;
            queued.clear();
        }

    }

    public static boolean should_evaporate(World world, BlockPos pos) {
        boolean kelp = world.getBlockState(pos).isOf(Blocks.KELP_PLANT) || world.getBlockState(pos).isOf(Blocks.KELP);
        boolean seagrass = world.getBlockState(pos).isOf(Blocks.SEAGRASS) || world.getBlockState(pos).isOf(Blocks.TALL_SEAGRASS);
        boolean sea_pickles = world.getBlockState(pos).isOf(Blocks.SEA_PICKLE);

        return (world.getBlockState(pos).isOf(Blocks.WATER) || kelp || seagrass || sea_pickles) && !world.isSkyVisibleAllowingSea(pos);
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
                    if (world.getBlockState(pos.add(0,1,0)).isOf(Blocks.WATER)) {
                        System.out.println("water found at" + pos);
                    }
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

        BlockState block = worldAccess.getBlockState(pos);
        return ModBlocks.get_wilted_from_unwilted(block);
    }

    public static Sprite[] get_water_sprites(boolean boiling) {
        Sprite boiling_still = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("solar_apocalypse","block/boiling_water_still")).getSprite();
        Sprite boiling_flow = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("solar_apocalypse","block/boiling_water_flow")).getSprite();
        Sprite still = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("minecraft","block/water_still")).getSprite();
        Sprite flow = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("minecraft","block/water_flow")).getSprite();
        return boiling ? new Sprite[]{boiling_still, boiling_flow} : new Sprite[]{still, flow};
    }


}
