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
import net.minecraft.util.Identifier;
import org.shadowmaster435.solar_apocalypse.block.*;

public class ModBlocks {
    public static final TransparentBlock IRON_GLASS = new TransparentBlock(FabricBlockSettings.create().sounds(BlockSoundGroup.GLASS).nonOpaque().strength(0.5f, 10f));
    public static final DryDirt DRY_SOIL = new DryDirt(FabricBlockSettings.create().sounds(ModSoundGroups.DRY_SOIL).ticksRandomly().strength(0.5f, 6f));
    public static final WiltedGrassBlock WILTED_GRASS_BLOCK = new WiltedGrassBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS_BLOCK).ticksRandomly().strength(0.6f, 6f));
    public static final WiltedTallPlantBlock WILTED_TALL_GRASS = new WiltedTallPlantBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().noCollision().breakInstantly());
    public static final WiltedPlantBlock WILTED_GRASS = new WiltedPlantBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().offset(AbstractBlock.OffsetType.XYZ).dynamicBounds().noCollision().breakInstantly());
    public static final WiltedPlantBlock WILTED_FERN = new WiltedPlantBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().offset(AbstractBlock.OffsetType.XYZ).dynamicBounds().noCollision().breakInstantly());
    public static final WiltedLeavesBlock WILTED_OAK_LEAVES = new WiltedLeavesBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().ticksRandomly().strength(0.5f, 0.5f));
    public static final WiltedLeavesBlock WILTED_BIRCH_LEAVES = new WiltedLeavesBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().ticksRandomly().strength(0.5f, 0.5f));
    public static final WiltedLeavesBlock WILTED_SPRUCE_LEAVES = new WiltedLeavesBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().ticksRandomly().strength(0.5f, 0.5f));
    public static final WiltedLeavesBlock WILTED_JUNGLE_LEAVES = new WiltedLeavesBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().ticksRandomly().strength(0.5f, 0.5f));
    public static final WiltedLeavesBlock WILTED_DARK_OAK_LEAVES = new WiltedLeavesBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().ticksRandomly().strength(0.5f, 0.5f));
    public static final WiltedLeavesBlock WILTED_ACACIA_LEAVES = new WiltedLeavesBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().ticksRandomly().strength(0.5f, 0.5f));
    public static final WiltedLeavesBlock WILTED_MANGROVE_LEAVES = new WiltedLeavesBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().ticksRandomly().strength(0.5f, 0.5f));
    public static final WiltedLeavesBlock WILTED_AZALEA_LEAVES = new WiltedLeavesBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().ticksRandomly().strength(0.5f, 0.5f));
    public static final WiltedLeavesBlock WILTED_FLOWERING_AZALEA_LEAVES = new WiltedLeavesBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().ticksRandomly().strength(0.5f, 0.5f));
    public static final WiltedLeavesBlock WILTED_CHERRY_LEAVES = new WiltedLeavesBlock(FabricBlockSettings.create().sounds(ModSoundGroups.WILTED_GRASS).nonOpaque().ticksRandomly().strength(0.5f, 0.5f));

    public static void init() {
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "iron_glass"), IRON_GLASS);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "iron_glass"), new BlockItem(IRON_GLASS, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "dry_soil"), DRY_SOIL);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "dry_soil"), new BlockItem(DRY_SOIL, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_grass_block"), WILTED_GRASS_BLOCK);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "wilted_grass_block"), new BlockItem(WILTED_GRASS_BLOCK, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_grass"), WILTED_GRASS);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "wilted_grass"), new BlockItem(WILTED_GRASS, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_fern"), WILTED_FERN);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "wilted_fern"), new BlockItem(WILTED_FERN, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier("solar_apocalypse", "wilted_tall_grass"), WILTED_TALL_GRASS);
        Registry.register(Registries.ITEM, new Identifier("solar_apocalypse", "wilted_tall_grass"), new BlockItem(WILTED_TALL_GRASS, new FabricItemSettings()));

        register_leaves();
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
    }
}
