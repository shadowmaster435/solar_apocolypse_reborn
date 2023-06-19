package org.shadowmaster435.solar_apocalypse.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateManager;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class PersistantStates extends PersistentState {

    public HashMap<UUID, PlayerState> players = new HashMap<>();

    public int day_count = 0;
    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        nbt.putInt("day_count", MiscUtil.loaded_day_count + MiscUtil.day);
        NbtCompound playersNbtCompound = new NbtCompound();
        players.forEach((UUID, playerSate) -> {
            NbtCompound playerStateNbt = new NbtCompound();

            // ANYTIME YOU PUT NEW DATA IN THE PlayerState CLASS YOU NEED TO REFLECT THAT HERE!!!
            playerStateNbt.putInt("heat", playerSate.heat);
            playerStateNbt.putInt("heat_delay", playerSate.heat_delay);

            playersNbtCompound.put(String.valueOf(UUID), playerStateNbt);
        });
        nbt.put("players", playersNbtCompound);
        return nbt;
    }

    public static PersistantStates createFromNbt(NbtCompound tag) {
        PersistantStates states = new PersistantStates();
        states.day_count = tag.getInt("day_count");
        NbtCompound playersTag = tag.getCompound("players");
        playersTag.getKeys().forEach(key -> {
            PlayerState playerState = new PlayerState();

            playerState.heat = playersTag.getCompound(key).getInt("heat");
            playerState.heat_delay = playersTag.getCompound(key).getInt("heat_delay");

            UUID uuid = UUID.fromString(key);
            states.players.put(uuid, playerState);
        });
        return states;
    }

    public static PersistantStates getPersistantStates(MinecraftServer server) {
        PersistentStateManager persistentStateManager = Objects.requireNonNull(server
                .getWorld(World.OVERWORLD)).getPersistentStateManager();

        return persistentStateManager.getOrCreate(
                org.shadowmaster435.solar_apocalypse.util.PersistantStates::createFromNbt,
                PersistantStates::new,
                "solar_apocalypse");
    }

    public static PlayerState getPlayerState(LivingEntity player) {
        PersistantStates serverState = getPersistantStates(Objects.requireNonNull(player.getEntityWorld().getServer()));
        return serverState.players.computeIfAbsent(player.getUuid(), uuid -> new PlayerState());
    }
}
