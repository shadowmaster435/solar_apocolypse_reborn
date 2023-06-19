package org.shadowmaster435.solar_apocalypse.registry;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final Identifier DRY_SOIL_PLACE = new Identifier("solar_apocalypse:dry_soil_place");
    public static SoundEvent DRY_SOIL_PLACE_EVENT = SoundEvent.of(DRY_SOIL_PLACE);
    public static final Identifier DRY_SOIL_DIG = new Identifier("solar_apocalypse:dry_soil_dig");
    public static SoundEvent DRY_SOIL_DIG_EVENT = SoundEvent.of(DRY_SOIL_DIG);
    public static final Identifier WILTED_GRASS_PLACE = new Identifier("solar_apocalypse:wilted_grass_place");
    public static SoundEvent WILTED_GRASS_PLACE_EVENT = SoundEvent.of(WILTED_GRASS_PLACE);
    public static final Identifier WILTED_GRASS_DIG = new Identifier("solar_apocalypse:wilted_grass_dig");
    public static SoundEvent WILTED_GRASS_DIG_EVENT = SoundEvent.of(WILTED_GRASS_DIG);
    public static final Identifier WILTED_GRASS_BLOCK_PLACE = new Identifier("solar_apocalypse:wilted_grass_block_place");
    public static SoundEvent WILTED_GRASS_BLOCK_PLACE_EVENT = SoundEvent.of(WILTED_GRASS_BLOCK_PLACE);
    public static final Identifier WILTED_GRASS_BLOCK_DIG = new Identifier("solar_apocalypse:wilted_grass_block_dig");
    public static SoundEvent WILTED_GRASS_BLOCK_DIG_EVENT = SoundEvent.of(WILTED_GRASS_BLOCK_DIG);

    public static void registerSounds() {
        Registry.register(Registries.SOUND_EVENT, DRY_SOIL_DIG, DRY_SOIL_DIG_EVENT);
        Registry.register(Registries.SOUND_EVENT, DRY_SOIL_PLACE, DRY_SOIL_PLACE_EVENT);
        Registry.register(Registries.SOUND_EVENT, WILTED_GRASS_DIG, WILTED_GRASS_DIG_EVENT);
        Registry.register(Registries.SOUND_EVENT, WILTED_GRASS_PLACE, WILTED_GRASS_PLACE_EVENT);
        Registry.register(Registries.SOUND_EVENT, WILTED_GRASS_BLOCK_PLACE, WILTED_GRASS_BLOCK_PLACE_EVENT);
    }
}
