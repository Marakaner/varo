package net.marakaner.varo;

import org.bukkit.plugin.java.JavaPlugin;

public class Varo extends JavaPlugin {

    private static Varo instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {

    }

    public static Varo getInstance() {
        return instance;
    }
}
