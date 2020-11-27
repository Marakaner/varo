package net.marakaner.varo;

import net.marakaner.varo.tablist.TablistManager;
import net.marakaner.varo.team.TeamManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Varo extends JavaPlugin {

    private static Varo instance;

    private TeamManager teamManager;
    private TablistManager tablistManager;

    private boolean started;

    @Override
    public void onEnable() {
        instance = this;
        this.teamManager = new TeamManager();
        this.tablistManager = new TablistManager();
    }

    @Override
    public void onDisable() {
        getTeamManager().saveTeams();
    }

    public TeamManager getTeamManager() {
        return teamManager;
    }

    public TablistManager getTablistManager() {
        return tablistManager;
    }

    public static Varo getInstance() {
        return instance;
    }
}
