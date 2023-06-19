package org.shadowmaster435.solar_apocalypse.registry;

import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;

public record ModSoundGroups(float volume, float pitch, SoundEvent breakSound, SoundEvent stepSound,
                             SoundEvent placeSound, SoundEvent hitSound, SoundEvent fallSound) {

    public static final BlockSoundGroup DRY_SOIL;
    public static final BlockSoundGroup WILTED_GRASS;
    public static final BlockSoundGroup WILTED_GRASS_BLOCK;

    static {
        DRY_SOIL = new BlockSoundGroup(1.0F, 1.0F, ModSounds.DRY_SOIL_PLACE_EVENT, ModSounds.DRY_SOIL_DIG_EVENT, ModSounds.DRY_SOIL_PLACE_EVENT, ModSounds.DRY_SOIL_DIG_EVENT, ModSounds.DRY_SOIL_PLACE_EVENT);
        WILTED_GRASS = new BlockSoundGroup(1.0F, 1.0F, ModSounds.WILTED_GRASS_PLACE_EVENT, ModSounds.WILTED_GRASS_DIG_EVENT, ModSounds.WILTED_GRASS_PLACE_EVENT, ModSounds.WILTED_GRASS_DIG_EVENT, ModSounds.WILTED_GRASS_PLACE_EVENT);
        WILTED_GRASS_BLOCK = new BlockSoundGroup(1.0F, 1.0F, ModSounds.WILTED_GRASS_BLOCK_PLACE_EVENT, ModSounds.WILTED_GRASS_BLOCK_DIG_EVENT, ModSounds.WILTED_GRASS_BLOCK_PLACE_EVENT, ModSounds.WILTED_GRASS_BLOCK_DIG_EVENT, ModSounds.WILTED_GRASS_BLOCK_PLACE_EVENT);

    }
}