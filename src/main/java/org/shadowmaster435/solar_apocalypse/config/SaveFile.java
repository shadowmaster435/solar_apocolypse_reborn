package org.shadowmaster435.solar_apocalypse.config;

import net.minecraft.client.MinecraftClient;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.WorldSavePath;
import net.minecraft.world.World;
import org.shadowmaster435.solar_apocalypse.util.HeatManager;
import org.shadowmaster435.solar_apocalypse.util.MiscUtil;

import javax.swing.text.html.parser.Entity;
import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class SaveFile {

    public static List<String> save_file = new ArrayList<>();

    public static String get_save_path() {
        MinecraftClient client = MinecraftClient.getInstance();
        IntegratedServer server = client.getServer();
        String worldIdentifier = "";
        if (server != null) {
            boolean remote = server.isRemote();
            if (remote) {
                assert client.world != null;
                worldIdentifier = client.world.toString();
            } else {
                worldIdentifier = client.getServer().getSavePath(WorldSavePath.ROOT).toString().replace(".", "");
            }
        }
        return worldIdentifier;
    }

    public static String get_world_name() {
        MinecraftClient client = MinecraftClient.getInstance();
        IntegratedServer server = client.getServer();
        String worldIdentifier = "";
        if (server != null && client.getCurrentServerEntry() != null) {
            boolean remote = server.isRemote();
            if (remote) {
                worldIdentifier = client.world.toString();
            } else {
                worldIdentifier = client.getServer().getSavePath(WorldSavePath.ROOT).getParent().getFileName().toString();
            }
        }
        return worldIdentifier;
    }
    public static void save(String world_name, int day, HashMap<ServerPlayerEntity, ArrayList<Integer>> player_data) {
        try {
            String save_data = create_save_string(world_name, day, player_data);
            File file = new File(get_save_path() + "solar_apocalypse/save_data.txt");
            File dir = new File(get_save_path() + "solar_apocalypse");
            dir.mkdir();
            FileOutputStream outputStream = new FileOutputStream(file);
            byte[] strToBytes = save_data.getBytes();
            outputStream.write(strToBytes);
            outputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static String create_save_string(String world_name, int day, HashMap<ServerPlayerEntity, ArrayList<Integer>> player_data) {
        StringBuilder builder = new StringBuilder("\nday:" + day + ",\nplayer_data: {");
        StringBuilder player_data_builder = new StringBuilder();
        for (ServerPlayerEntity entity : player_data.keySet()) {
            int heat = player_data.get(entity).get(0);
            int heat_delay = player_data.get(entity).get(1);
            String id = entity.getUuidAsString();
            player_data_builder.append(id).append(":{");
            player_data_builder.append("heat:").append(heat).append(",");
            player_data_builder.append("heat_delay:").append(heat_delay);
            player_data_builder.append("}");
        }
        builder.append(player_data_builder).append("}");
        return builder.toString();
    }

    public static void read_save() {
        try {
            Path file = Paths.get(get_save_path() + "solar_apocalypse/save_data.txt");

            Stream<String> stream = Files.lines(file);
            save_file = stream.toList();
            stream.close();
            save_file.removeIf(s -> s.matches("\\[]\\{}"));
            MiscUtil.day = Integer.parseInt(save_file.get(1).substring(4));
            HeatManager.player_heat_map = read_player_data();
        } catch (Exception ignored) {

        }
    }

    public static HashMap<UUID, ArrayList<Integer>> read_player_data() {
        ArrayList<Integer> val_list = new ArrayList<>();
        HashMap<UUID, ArrayList<Integer>> result = new HashMap<>();
        String data_string = save_file.get(2);
        boolean uuid_mode = false;
        boolean val_mode = false;
        StringBuilder uuid_builder = new StringBuilder();
        StringBuilder val_builder = new StringBuilder();

        for (int index : data_string.chars().toArray()) {

            if (data_string.charAt(index) == '{') {
                uuid_mode = true;
            }
            if (uuid_mode && data_string.charAt(index) == '{') {
                val_mode = true;
                uuid_mode = false;
            }
            if (val_mode && data_string.charAt(index) == '}') {
                val_mode = false;
            }
            boolean b = data_string.charAt(index) != ':' && data_string.charAt(index) != '{' && data_string.charAt(index) != '}'&& data_string.charAt(index) != '[' && data_string.charAt(index) != ']' ;
            if (uuid_mode) {
                if (b) {
                    uuid_builder.append(data_string.charAt(index));
                }
            }
            if (val_mode) {
                if (b) {
                    val_builder.append(data_string.charAt(index));
                }
            }
        }
        val_list.add(Integer.valueOf(val_builder.substring(0,val_builder.indexOf(",")).replace("heat:", "")));
        val_list.add(Integer.valueOf(val_builder.substring(val_builder.indexOf(",") + 1).replace("heat_delay:", "")));
        result.put(UUID.fromString(uuid_builder.toString()), val_list);
        return result;
    }



}
