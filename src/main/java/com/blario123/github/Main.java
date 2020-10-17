package com.blario123.github;

import com.blario123.github.command.AdView;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("adview").setExecutor(new AdView(this));
        getLogger().info("Started AdView.");
    }

    @Override
    public void onDisable(){
        getLogger().info("Stopping Adview");
    }
}
