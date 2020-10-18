package com.blario123.github.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.craftbukkit.v1_16_R2.CraftServer;

public abstract class CommandBase extends Command {
    public CommandBase(String name){
        super(name);
        SimpleCommandMap commandMap = ((CraftServer) Bukkit.getServer()).getCommandMap();
        commandMap.register(name, "adview", this);
    }

    public static void makeCommands(){
        new AdView();
    }
}
