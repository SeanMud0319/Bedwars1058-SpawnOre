package com.nontage.listeners;

import com.andrei1058.bedwars.api.arena.GameState;
import com.andrei1058.bedwars.api.arena.generator.GeneratorType;
import com.andrei1058.bedwars.api.events.gameplay.GameStateChangeEvent;
import com.nontage.SpawnOre;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class GameStart implements Listener {
    @EventHandler
    public void onGameStart(GameStateChangeEvent e) {
        if (e.getNewState() == GameState.playing) {

            e.getArena().getOreGenerators().forEach(a -> {
                if (a.getType() == GeneratorType.DIAMOND) {
                    Bukkit.getScheduler().runTaskLater(SpawnOre.plugin, () -> {
                        a.dropItem(a.getLocation());
                    }, 20L);
                } else if (a.getType() == GeneratorType.EMERALD) {
                    Bukkit.getScheduler().runTaskLater(SpawnOre.plugin, () -> {
                        a.dropItem(a.getLocation());
                    }, 20L);
                }
            });

        }
    }
}
