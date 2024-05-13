package com.nontage;


import com.andrei1058.bedwars.api.BedWars;
import com.nontage.listeners.GameStart;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class SpawnOre extends JavaPlugin {
    public static BedWars bw;
    public static SpawnOre plugin;
    @Override
    public void onEnable() {
        getLogger().info("Enabling plugin...");
        plugin = this;
        if (Bukkit.getPluginManager().getPlugin("BedWars1058") == null) {
            getLogger().severe("BedWars1058 was not found. Disabling...");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        var registration = Bukkit.getServicesManager().getRegistration(BedWars.class);
        if (null == registration) {
            getLogger().severe("Cannot hook into BedWars1058.");
            Bukkit.getPluginManager().disablePlugin(plugin);
            return;
        }
        Bukkit.getPluginManager().registerEvents(new GameStart(), this);

        bw = registration.getProvider();

        getLogger().info("Hooked into BedWars1058!");
    }

}