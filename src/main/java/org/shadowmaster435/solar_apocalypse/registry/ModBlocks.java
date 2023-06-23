package org.shadowmaster435.solar_apocalypse.registry;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import org.shadowmaster435.solar_apocalypse.block.*;

public class ModBlocks {
    public static final TransparentBlock IRON_GLASS = new TransparentBlock(FabricBlockSettings.create().sounds(BlockSoundGroup.GLASS).nonOpaque().strength(0.5f, 2f));
    public static final DryDirt DRY_SOIL = new DryDirt(FabricBlockSettings.create().sounds(ModSoundGroups.DRY_SOIL).ticksRandomly().strength(0.5f, 0.5f));
    public static final WiltedGrassBlock WILTED_GRASS_BLOCK = new WiltedGrassBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS_BLOCK).ticksRandomly().strength(0.6f, 0.6f));
    public static final WiltedPlantBlock WILTED_GRASS = new WiltedPlantBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().offset(AbstractBlock.OffsetType.XYZ).dynamicBounds().noCollision().breakInstantly());
    public static final WiltedPlantBlock WILTED_FERN = new WiltedPlantBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().offset(AbstractBlock.OffsetType.XYZ).dynamicBounds().noCollision().breakInstantly());
    public static final WiltedLeavesBlock WILTED_OAK_LEAVES = new WiltedLeavesBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().ticksRandomly().strength(0.2f, 0.2f));
    public static final WiltedLeavesBlock WILTED_BIRCH_LEAVES = new WiltedLeavesBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().ticksRandomly().strength(0.2f, 0.2f));
    public static final WiltedLeavesBlock WILTED_SPRUCE_LEAVES = new WiltedLeavesBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().ticksRandomly().strength(0.2f, 0.2f));
    public static final WiltedLeavesBlock WILTED_JUNGLE_LEAVES = new WiltedLeavesBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().ticksRandomly().strength(0.2f, 0.2f));
    public static final WiltedLeavesBlock WILTED_DARK_OAK_LEAVES = new WiltedLeavesBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().ticksRandomly().strength(0.2f, 0.2f));
    public static final WiltedLeavesBlock WILTED_ACACIA_LEAVES = new WiltedLeavesBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().ticksRandomly().strength(0.2f, 0.2f));
    public static final WiltedLeavesBlock WILTED_MANGROVE_LEAVES = new WiltedLeavesBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().ticksRandomly().strength(0.2f, 0.2f));
    public static final WiltedLeavesBlock WILTED_AZALEA_LEAVES = new WiltedLeavesBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().ticksRandomly().strength(0.2f, 0.2f));
    public static final WiltedLeavesBlock WILTED_FLOWERING_AZALEA_LEAVES = new WiltedLeavesBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().ticksRandomly().strength(0.2f, 0.2f));
    public static final WiltedLeavesBlock WILTED_CHERRY_LEAVES = new WiltedLeavesBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().ticksRandomly().strength(0.2f, 0.2f));
    public static final WiltedTallPlantBlock WILTED_TALL_GRASS = new WiltedTallPlantBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).offset(AbstractBlock.OffsetType.XZ).nonOpaque().noCollision().breakInstantly());
    public static final WiltedTallPlantBlock WILTED_LARGE_FERN = new WiltedTallPlantBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).offset(AbstractBlock.OffsetType.XZ).nonOpaque().noCollision().breakInstantly());
    public static final WiltedTallPlantBlock WILTED_PEONY = new WiltedTallPlantBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).offset(AbstractBlock.OffsetType.XZ).nonOpaque().noCollision().breakInstantly());
    public static final WiltedTallPlantBlock WILTED_ROSE_BUSH = new WiltedTallPlantBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).offset(AbstractBlock.OffsetType.XZ).nonOpaque().noCollision().breakInstantly());
    public static final WiltedTallPlantBlock WILTED_LILAC = new WiltedTallPlantBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).offset(AbstractBlock.OffsetType.XZ).nonOpaque().noCollision().breakInstantly());
    public static final WiltedSunflower WILTED_SUNFLOWER = new WiltedSunflower(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).offset(AbstractBlock.OffsetType.XZ).nonOpaque().noCollision().breakInstantly());
    public static final WiltedPlantBlock WILTED_ALLIUM = new WiltedPlantBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().offset(AbstractBlock.OffsetType.XZ).dynamicBounds().noCollision().breakInstantly());
    public static final WiltedFlowerBlock WILTED_LILY_OF_THE_VALLEY = new WiltedFlowerBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().offset(AbstractBlock.OffsetType.XZ).dynamicBounds().noCollision().breakInstantly());
    public static final WiltedPlantBlock WILTED_AZURE_BLUET = new WiltedPlantBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().offset(AbstractBlock.OffsetType.XZ).dynamicBounds().noCollision().breakInstantly());
    public static final WiltedFlowerBlock WILTED_POPPY = new WiltedFlowerBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().offset(AbstractBlock.OffsetType.XZ).dynamicBounds().noCollision().breakInstantly());
    public static final WiltedFlowerBlock WILTED_DANDELION = new WiltedFlowerBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().offset(AbstractBlock.OffsetType.XZ).dynamicBounds().noCollision().breakInstantly());
    public static final WiltedFlowerBlock WILTED_OXEYE_DAISY = new WiltedFlowerBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().offset(AbstractBlock.OffsetType.XZ).dynamicBounds().noCollision().breakInstantly());
    public static final WiltedFlowerBlock WILTED_CORNFLOWER = new WiltedFlowerBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().offset(AbstractBlock.OffsetType.XZ).dynamicBounds().noCollision().breakInstantly());
    public static final WiltedFlowerBlock WILTED_TULIP = new WiltedFlowerBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().offset(AbstractBlock.OffsetType.XZ).dynamicBounds().noCollision().breakInstantly());
    public static final WiltedPlantBlock WILTED_BLUE_ORCHID = new WiltedPlantBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().offset(AbstractBlock.OffsetType.XZ).dynamicBounds().noCollision().breakInstantly());
    public static final WiltedWheatCropBlock WILTED_WHEAT = new WiltedWheatCropBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().offset(AbstractBlock.OffsetType.XZ).dynamicBounds().noCollision().breakInstantly(), new int[]{});
    public static final WiltedCropBlock WILTED_BEETROOTS = new WiltedCropBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().offset(AbstractBlock.OffsetType.XZ).dynamicBounds().noCollision().breakInstantly(), new int[]{});
    public static final WiltedCropBlock WILTED_CARROTS = new WiltedCropBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().offset(AbstractBlock.OffsetType.XZ).dynamicBounds().noCollision().breakInstantly(),  new int[]{});
    public static final WiltedCropBlock WILTED_POTATOES = new WiltedCropBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().offset(AbstractBlock.OffsetType.XZ).dynamicBounds().noCollision().breakInstantly(),  new int[]{});
    public static final WiltedSweetBerryBush WILTED_SWEET_BERRY_BUSH = new WiltedSweetBerryBush(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().offset(AbstractBlock.OffsetType.XZ).dynamicBounds().noCollision().breakInstantly());

    public static void init() {
        register_plants();
        register_misc();
        register_leaves();
    }

    public static void register_misc() {
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "iron_glass"), IRON_GLASS);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "iron_glass"), new BlockItem(IRON_GLASS, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "dry_soil"), DRY_SOIL);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "dry_soil"), new BlockItem(DRY_SOIL, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_grass_block"), WILTED_GRASS_BLOCK);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "wilted_grass_block"), new BlockItem(WILTED_GRASS_BLOCK, new FabricItemSettings()));

    }

    public static void register_leaves() {
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_oak_leaves"), WILTED_OAK_LEAVES);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "wilted_oak_leaves"), new BlockItem(WILTED_OAK_LEAVES, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_birch_leaves"), WILTED_BIRCH_LEAVES);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "wilted_birch_leaves"), new BlockItem(WILTED_BIRCH_LEAVES, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_spruce_leaves"), WILTED_SPRUCE_LEAVES);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "wilted_spruce_leaves"), new BlockItem(WILTED_SPRUCE_LEAVES, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_jungle_leaves"), WILTED_JUNGLE_LEAVES);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "wilted_jungle_leaves"), new BlockItem(WILTED_JUNGLE_LEAVES, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_acacia_leaves"), WILTED_ACACIA_LEAVES);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "wilted_acacia_leaves"), new BlockItem(WILTED_ACACIA_LEAVES, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_dark_oak_leaves"), WILTED_DARK_OAK_LEAVES);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "wilted_dark_oak_leaves"), new BlockItem(WILTED_DARK_OAK_LEAVES, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_mangrove_leaves"), WILTED_MANGROVE_LEAVES);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "wilted_mangrove_leaves"), new BlockItem(WILTED_MANGROVE_LEAVES, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_azalea_leaves"), WILTED_AZALEA_LEAVES);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "wilted_azalea_leaves"), new BlockItem(WILTED_AZALEA_LEAVES, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_flowering_azalea_leaves"), WILTED_FLOWERING_AZALEA_LEAVES);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "wilted_flowering_azalea_leaves"), new BlockItem(WILTED_FLOWERING_AZALEA_LEAVES, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_cherry_leaves"), WILTED_CHERRY_LEAVES);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "wilted_cherry_leaves"), new BlockItem(WILTED_CHERRY_LEAVES, new FabricItemSettings()));
    }

    public static void register_plants() {
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_grass"), WILTED_GRASS);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "wilted_grass"), new BlockItem(WILTED_GRASS, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_fern"), WILTED_FERN);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "wilted_fern"), new BlockItem(WILTED_FERN, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_tall_grass"), WILTED_TALL_GRASS);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "wilted_tall_grass"), new BlockItem(WILTED_TALL_GRASS, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_large_fern"), WILTED_LARGE_FERN);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "wilted_large_fern"), new BlockItem(WILTED_LARGE_FERN, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_sunflower"), WILTED_SUNFLOWER);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "wilted_sunflower"), new BlockItem(WILTED_SUNFLOWER, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_lilac"), WILTED_LILAC);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "wilted_lilac"), new BlockItem(WILTED_LILAC, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_rose_bush"), WILTED_ROSE_BUSH);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "wilted_rose_bush"), new BlockItem(WILTED_ROSE_BUSH, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_peony"), WILTED_PEONY);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "wilted_peony"), new BlockItem(WILTED_PEONY, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_dandelion"), WILTED_DANDELION);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "wilted_dandelion"), new BlockItem(WILTED_DANDELION, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_tulip"), WILTED_TULIP);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "wilted_tulip"), new BlockItem(WILTED_TULIP, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_poppy"), WILTED_POPPY);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "wilted_poppy"), new BlockItem(WILTED_POPPY, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_azure_bluet"), WILTED_AZURE_BLUET);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "wilted_azure_bluet"), new BlockItem(WILTED_AZURE_BLUET, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_blue_orchid"), WILTED_BLUE_ORCHID);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "wilted_blue_orchid"), new BlockItem(WILTED_BLUE_ORCHID, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_lily_of_the_valley"), WILTED_LILY_OF_THE_VALLEY);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "wilted_lily_of_the_valley"), new BlockItem(WILTED_LILY_OF_THE_VALLEY, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_allium"), WILTED_ALLIUM);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "wilted_allium"), new BlockItem(WILTED_ALLIUM, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_cornflower"), WILTED_CORNFLOWER);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "wilted_cornflower"), new BlockItem(WILTED_CORNFLOWER, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_oxeye_daisy"), WILTED_OXEYE_DAISY);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "wilted_oxeye_daisy"), new BlockItem(WILTED_OXEYE_DAISY, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_wheat"), WILTED_WHEAT);
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_potatoes"), WILTED_POTATOES);
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_carrots"), WILTED_CARROTS);
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_beetroots"), WILTED_BEETROOTS);
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_sweet_berry_bush"), WILTED_SWEET_BERRY_BUSH);
    }


    public static BlockState get_wilted_from_unwilted(BlockState state) {
        Block block = state.getBlock();
        BlockState result;
        if (block.equals(Blocks.OAK_LEAVES)) {
            result = WILTED_OAK_LEAVES.getDefaultState();
        } else if (block.equals(Blocks.BIRCH_LEAVES)) {
            result = WILTED_BIRCH_LEAVES.getDefaultState();
        } else if (block.equals(Blocks.SPRUCE_LEAVES)) {
            result = WILTED_SPRUCE_LEAVES.getDefaultState();
        } else if (block.equals(Blocks.JUNGLE_LEAVES)) {
            result = WILTED_JUNGLE_LEAVES.getDefaultState();
        } else if (block.equals(Blocks.MANGROVE_LEAVES)) {
            result = WILTED_MANGROVE_LEAVES.getDefaultState();
        } else if (block.equals(Blocks.FLOWERING_AZALEA_LEAVES)) {
            result = WILTED_FLOWERING_AZALEA_LEAVES.getDefaultState();
        } else if (block.equals(Blocks.AZALEA)) {
            result = WILTED_AZALEA_LEAVES.getDefaultState();
        } else if (block.equals(Blocks.DARK_OAK_LEAVES)) {
            result = WILTED_DARK_OAK_LEAVES.getDefaultState();
        } else if (block.equals(Blocks.ACACIA_LEAVES)) {
            result = WILTED_ACACIA_LEAVES.getDefaultState();
        } else if (block.equals(Blocks.SUNFLOWER)) {
            result = WILTED_SUNFLOWER.getDefaultState();
        } else if (block.equals(Blocks.LILAC)) {
            result = WILTED_LILAC.getDefaultState();
        } else if (block.equals(Blocks.PEONY)) {
            result = WILTED_PEONY.getDefaultState();
        } else if (block.equals(Blocks.ROSE_BUSH)) {
            result = WILTED_ROSE_BUSH.getDefaultState();
        } else if (block.equals(Blocks.TALL_GRASS)) {
            result = WILTED_TALL_GRASS.getDefaultState();
        } else if (block.equals(Blocks.FERN)) {
            result = WILTED_FERN.getDefaultState();
        } else if (block.equals(Blocks.GRASS)) {
            result = WILTED_GRASS.getDefaultState();
        } else if (block.equals(Blocks.GRASS_BLOCK) || block.equals(Blocks.DIRT_PATH)) {
            result = WILTED_GRASS_BLOCK.getDefaultState();
        } else if (block.equals(Blocks.LARGE_FERN)) {
            result = WILTED_LARGE_FERN.getDefaultState();
        } else if (block.equals(Blocks.ALLIUM)) {
            result = WILTED_ALLIUM.getDefaultState();
        } else if (block.equals(Blocks.AZURE_BLUET)) {
            result = WILTED_AZURE_BLUET.getDefaultState();
        } else if (block.equals(Blocks.BLUE_ORCHID)) {
            result = WILTED_BLUE_ORCHID.getDefaultState();
        } else if (block.equals(Blocks.CORNFLOWER)) {
            result = WILTED_CORNFLOWER.getDefaultState();
        }else if (block.equals(Blocks.POPPY)) {
            result = WILTED_POPPY.getDefaultState();
        } else if (block.equals(Blocks.DANDELION)) {
            result = WILTED_DANDELION.getDefaultState();
        } else if (block.equals(Blocks.LILY_OF_THE_VALLEY)) {
            result = WILTED_LILY_OF_THE_VALLEY.getDefaultState();
        } else if (block.equals(Blocks.OXEYE_DAISY)) {
            result = WILTED_OXEYE_DAISY.getDefaultState();
        } else if (is_tulip(block)) {
            result = WILTED_TULIP.getDefaultState();
        } else if (block.equals(Blocks.WHEAT)) {
            result = getCropState(state, WILTED_WHEAT);
        } else if (block.equals(Blocks.BEETROOTS)) {
            result = getCropState(state, WILTED_BEETROOTS);
        } else if (block.equals(Blocks.CARROTS)) {
            result = getCropState(state, WILTED_CARROTS);
        } else if (block.equals(Blocks.POTATOES)) {
            result = getCropState(state, WILTED_POTATOES);
        } else if (is_valid_dirt(block)) {
            result = DRY_SOIL.getDefaultState();
        } else if (block.equals(Blocks.ICE) || block.equals(Blocks.BLUE_ICE) || block.equals(Blocks.POWDER_SNOW)) {
            result = Blocks.WATER.getDefaultState().with(FluidBlock.LEVEL, 8);
        } else if (block.equals(Blocks.PACKED_ICE) || block.equals(Blocks.SNOW) || block.equals(Blocks.SNOW_BLOCK)) {
            result = Blocks.AIR.getDefaultState();
        } else {
            result = state;
        }
        return result;
    }
    public static BlockState getCropState(BlockState state, WiltedCropBlock block) {
        if (state.isOf(Blocks.SWEET_BERRY_BUSH)) {
            return WILTED_SWEET_BERRY_BUSH.getDefaultState().with(WiltedSweetBerryBush.STAGE, Math.min(state.get(CropBlock.AGE), 1));
        } else {
            if (state.isOf(Blocks.WHEAT)) {
                return block.getDefaultState().with(Properties.STAGE, state.get(CropBlock.AGE));
            } else {
                return block.getDefaultState().with(Properties.STAGE, Math.min(state.get(CropBlock.AGE), 3));

            }
        }
    }

    public static boolean is_valid_dirt(Block block) {
        return block.equals(Blocks.DIRT) || block.equals(Blocks.PODZOL) || block.equals(Blocks.COARSE_DIRT) || block.equals(Blocks.FARMLAND) || block.equals(Blocks.ROOTED_DIRT) || block == Blocks.MUD || block.equals(Blocks.MUDDY_MANGROVE_ROOTS);
    }
    public static boolean is_tulip(Block block) {
        return block.equals(Blocks.ORANGE_TULIP) || block.equals(Blocks.RED_TULIP) || block.equals(Blocks.WHITE_TULIP) || block.equals(Blocks.PINK_TULIP);
    }

    public static void init_client() {
        registerBlockLayerTypes();
    }
    public static void registerBlockLayerTypes() {
        BlockRenderLayerMap.INSTANCE.putBlock(IRON_GLASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WILTED_OAK_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WILTED_BIRCH_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WILTED_SPRUCE_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WILTED_JUNGLE_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WILTED_ACACIA_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WILTED_DARK_OAK_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WILTED_MANGROVE_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WILTED_AZALEA_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WILTED_FLOWERING_AZALEA_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WILTED_CHERRY_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WILTED_FERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WILTED_TALL_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WILTED_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WILTED_LARGE_FERN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WILTED_POPPY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WILTED_CORNFLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WILTED_AZURE_BLUET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WILTED_BLUE_ORCHID, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WILTED_DANDELION, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WILTED_ALLIUM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WILTED_TULIP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WILTED_LILY_OF_THE_VALLEY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WILTED_OXEYE_DAISY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WILTED_SUNFLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WILTED_SWEET_BERRY_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WILTED_LILAC, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WILTED_PEONY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WILTED_ROSE_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WILTED_POTATOES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WILTED_CARROTS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WILTED_BEETROOTS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(WILTED_WHEAT, RenderLayer.getCutout());
    }
}
