package com.blario123.github.command;

import com.blario123.github.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;

public class AdView implements CommandExecutor {
    private final Main plugin;
    public AdView(Main plugin){
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        final Collection<? extends Player> players = Bukkit.getOnlinePlayers();
        Bukkit.broadcastMessage("\nArguments:" + args[0]);
        return true;
//        if(Arrays.asList(players).contains(args);
    }
}