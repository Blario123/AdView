package com.blario123.github.command;

import com.google.gson.Gson;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AdView extends CommandBase {
    static final ClassLoader loader = AdView.class.getClassLoader();
    public AdView(){
        super("adview");
        this.setAliases(Arrays.asList("adview"));
    }

    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] strings) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/advancements.json")))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = br.readLine()) != null){
                sb.append(line);
            }
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(sb.toString());
            Bukkit.broadcastMessage(String.valueOf(json.get("nether")));
        } catch(Exception e){
            e.printStackTrace();
        }
        String toCheck;
        boolean found;
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            if(strings.length <= 1) {
                if(strings.length == 1) {
                    toCheck = strings[0];
                } else {
                    toCheck = player.getDisplayName();
                }
                found = false;
                for(Player player1 : Bukkit.getOnlinePlayers()) {
                    if(player1.getDisplayName().equals(toCheck)) found = true;
                }
                if(found){
                    String[] pages = {"nether", "adventure", "the_end", "husbandry", "minecraft"};
                    player.sendMessage("Checking " + toCheck + "'s advancements");
                    Inventory inv = Bukkit.createInventory(null, 54, String.format("%s's advancements", toCheck));
                    player.openInventory(inv);
                }
                else {
                    player.sendMessage("Could not find player " + toCheck);
                }
            }
            else {
                player.sendMessage("Only one player can be viewed");
            }
            return true;
        }
        else {
            Bukkit.getLogger().info("This command can only be run as a player.");
            return false;
        }
    }
}