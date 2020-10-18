package com.blario123.github;

import com.blario123.github.command.CommandBase;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {


    @Override
    public void onEnable() {
        CommandBase.makeCommands();
        getLogger().info("Started AdView.");
    }

    @Override
    public void onDisable(){
        getLogger().info("Stopping Adview");
    }
}
