package net.marakaner.varo;

import net.marakaner.varo.rank.Rank;
import net.marakaner.varo.rank.RankManager;
import net.marakaner.varo.team.TeamManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Varo extends JavaPlugin {

    private static Varo instance;

    private RankManager rankManager;
    private TeamManager teamManager;

    @Override
    public void onEnable() {
        instance = this;
        this.rankManager = new RankManager();
        this.teamManager = new TeamManager();
    }

    @Override
    public void onDisable() {

    }

    public RankManager getRankManager() {
        return rankManager;
    }

    public TeamManager getTeamManager() {
        return teamManager;
    }

    public static Varo getInstance() {
        return instance;
    }
}
