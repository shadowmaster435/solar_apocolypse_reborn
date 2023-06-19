package org.shadowmaster435.solar_apocalypse;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.shadowmaster435.solar_apocalypse.registry.ModBlocks;
import org.shadowmaster435.solar_apocalypse.registry.ModItems;
import org.shadowmaster435.solar_apocalypse.registry.ModSounds;
import org.shadowmaster435.solar_apocalypse.util.ModNetworkConstants;
import org.shadowmaster435.solar_apocalypse.util.PersistantStates;
import org.shadowmaster435.solar_apocalypse.util.PlayerState;

public class SolarApocalypse implements ModInitializer {

    private static final ItemGroup MOD_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.MOD_ICON))
            .displayName(Text.translatable("itemGroup.solar_apocalypse.mod_tab"))
            .build();
    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM_GROUP, new Identifier("solar_apocalypse", "mod_tab"), MOD_TAB);

        ItemGroupEvents.modifyEntriesEvent(Registries.ITEM_GROUP.getKey(MOD_TAB).get()).register(content -> {
            content.add(ModBlocks.IRON_GLASS);
            content.add(ModBlocks.DRY_SOIL);
        });
        ModBlocks.init();
        ModItems.registerItems();
        ModSounds.registerSounds();
        ServerPlayNetworking.registerGlobalReceiver(ModNetworkConstants.DATA_ID, (server1, player, handler1, buf, responseSender) -> {
            ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {


                PersistantStates states = PersistantStates.getPersistantStates(handler.player.getServerWorld().getServer());
                PlayerState playerState = PersistantStates.getPlayerState(handler.player);

                PacketByteBuf data = PacketByteBufs.create();
                data.writeInt(states.day_count);
                data.writeInt(playerState.heat);
                data.writeInt(playerState.heat_delay);
                ServerPlayNetworking.send(handler.player, ModNetworkConstants.DATA_ID, data);
            });
        });
    }
}
